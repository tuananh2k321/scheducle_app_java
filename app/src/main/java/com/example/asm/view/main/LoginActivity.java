package com.example.asm.view.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.api_res.LoginReq;
import com.example.asm.api_res.LoginRes;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;
import com.example.asm.view.main.Adapter.ListSchoolAdapter;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView tvchoose;
    Button btnLogin;

    AlertDialog.Builder builder;
    ListSchoolAdapter adapter;

    //gg auth
    FirebaseAuth auth;
    FirebaseDatabase database;
    GoogleSignInClient gsc;
    ProgressDialog progressDialog;

    SharedPreferences sharedPreferences;
    String student_code;

    int RC_SIGN_IN = 50;

    Users users;
    FirebaseUser user;
    String emailFirebase;
    String address;
    IRetrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvchoose = findViewById(R.id.tv_choose);
        btnLogin = findViewById(R.id.btn);

        builder = new AlertDialog.Builder(this);

        List<String> list = new ArrayList<>();
        list.add("FPT Polytechnic Hồ Chí Minh");
        list.add("FPT Polytechnic Hà Nội");
        list.add("FPT Polytechnic HO");
        list.add("FPT Polytechnic Cần Thơ");
        list.add("FPT Polytechnic Đà Nẵng");

        adapter = new ListSchoolAdapter(LoginActivity.this, list);

        //tv school


        tvchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectItem = list.get(which);
                        tvchoose.setText(selectItem);
                        address= selectItem.toString();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        sharedPreferences = getSharedPreferences("data_user", MODE_PRIVATE);


        FirebaseApp.initializeApp(this);
        //gg
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Đăng nhập");
        progressDialog.setMessage("Thành công!!");

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                                .build();

        gsc = GoogleSignIn.getClient(this, gso);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }


    private void signIn() {
        Intent intent = gsc.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            }catch (ApiException e){
                throw new RuntimeException(e);
            }
        }
    }

    private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);

        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            user = auth.getCurrentUser();

                            users = new Users();
                            users.setUserId(user.getUid());
                            users.setName(user.getDisplayName());
                            users.setProfile(user.getPhotoUrl().toString());
                            users.setEmail(user.getEmail());

                            Log.d("___________", "onComplete: "+ user.getPhotoUrl().toString());

                            emailFirebase = user.getEmail();
                            int index = emailFirebase.indexOf('@');
                            if (index >= 0 && index >=7){
                                student_code = emailFirebase.substring(index - 7, index);
                                Log.d("student codedddddddđ", "onComplete: "+student_code);
                            }

                            Log.d("users", "abc>>>>>>>>>: "+ users.toString());

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("name_user", users.name);
                            editor.putString("email_user", users.email);
                            editor.putString("student_code", student_code);
                            editor.putString("img_user", user.getPhotoUrl().toString());
                            editor.commit();


                            IretrofitLogin1();
//                            IretrofitRegister();
                            //databáe realtime
//                            database.getReference()
//                                    .child("Users")
//                                    .child(user.getUid())
//                                    .setValue(users);

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void IretrofitLogin1(){
        retrofit = RetrofitHelper.createService(IRetrofit.class);
        LoginReq loginRequestDTO = new LoginReq(user.getEmail(), user.getDisplayName(), address);
        retrofit.login(loginRequestDTO).enqueue(login);
    }

    Callback<LoginRes> login = new Callback<LoginRes>() {
        @Override
        public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
            if (response.isSuccessful()){
                LoginRes loginResponse = response.body();
                if (loginResponse.isStatus()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    //thành công, sang home
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<LoginRes> call, Throwable t) {
            Log.d(">>> login fail", "onFailure: " + t.getMessage());
        }
    };



    }