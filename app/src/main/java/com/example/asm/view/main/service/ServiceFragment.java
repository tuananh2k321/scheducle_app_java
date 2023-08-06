package com.example.asm.view.main.service;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.asm.R;
import com.example.asm.view.main.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class ServiceFragment extends Fragment {

    private LinearLayout dangki_dv,linearLayout2,linearLayout3,linearLayout5, logout;
    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dangki_dv =view.findViewById(R.id.dangki_dv);
        linearLayout2 =view.findViewById(R.id.linearLayout2);
        linearLayout3 =view.findViewById(R.id.linearLayout3);
        linearLayout5 =view.findViewById(R.id.linearLayout5);
        logout = view.findViewById(R.id.logout_gg);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOutGG();
            }
        });


        //gg
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                        .build();

        gsc = GoogleSignIn.getClient(getActivity(), gso);

//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());

        dangki_dv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ServiceCompleteAcctivity.class));
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FormBangDiemActivity.class));
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FromCardStudentActivity.class));
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FormConfirmStudentActivity.class));
            }
        });
    }


    //logout gg

    public void LogOutGG(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
                getActivity().finish();
            }
        });
    }
}