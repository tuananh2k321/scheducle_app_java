package com.example.asm.view.main.service;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm.R;
import com.example.asm.view.main.Interface.IRetrofit;
import com.example.asm.view.main.dto.InsertBangDiemServiceRequestDTO;
import com.example.asm.view.main.dto.InsertConfirmStudentServiceRequestDTO;
import com.example.asm.view.main.dto.InsertStudentServiceResponseDTO;
import com.example.asm.view.main.helper.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormConfirmStudentActivity extends AppCompatActivity {
    TextView tv_xacnhan,tv_mucdich;
    EditText edt_sdt,edt_note;
    Button btn_submit;
    AlertDialog.Builder builder;

    IRetrofit iRetrofit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_sinhvien_activity);

        initView();

        builder = new AlertDialog.Builder(this);

// show dialog muc dich
        tv_mucdich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder
                        .setItems(R.array.item_array2, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String[] items = getResources().getStringArray(R.array.item_array2);
                                String selectedItem = items[which];
                                tv_mucdich.setText(selectedItem);
                            }
                        });
                builder.show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = "Giấy xác nhận sinh viên";
                String studentCode = "ps24524";
                String note = edt_note.getText().toString();
                String phoneNumber = edt_sdt.getText().toString();
                String mucdich = tv_mucdich.getText().toString();
                String confirm = tv_xacnhan.getText().toString();
                iRetrofit = RetrofitHelper.createService(IRetrofit.class);
                InsertConfirmStudentServiceRequestDTO insertConfirmStudentServiceRequestDTO
                        = new InsertConfirmStudentServiceRequestDTO(service,studentCode,phoneNumber,note,mucdich,confirm,1);
                iRetrofit.insertConfirm(insertConfirmStudentServiceRequestDTO).enqueue(insert);
            }
        });
    }

    // show dialog xac nhan
    public void showItemSelectionDialog(View view) {
        builder
                .setItems(R.array.item_array1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.item_array1);
                        String selectedItem = items[which];

                        tv_xacnhan.setText(selectedItem);
                    }
                });
        builder.show();
    }
    // back ve screen truoc toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initView(){
        tv_xacnhan = findViewById(R.id.tv_xacnhan);
        tv_mucdich = findViewById(R.id.tv_mucdich);
        edt_note = findViewById(R.id.edt_note);
        edt_sdt = findViewById(R.id.edt_sdt);
        btn_submit = findViewById(R.id.btn_submit);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        // hiển thị nút back trên thanh toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    Callback<InsertStudentServiceResponseDTO> insert = new Callback<InsertStudentServiceResponseDTO>() {
        @Override
        public void onResponse(Call<InsertStudentServiceResponseDTO> call, Response<InsertStudentServiceResponseDTO> response) {
            if (response.isSuccessful()){
                InsertStudentServiceResponseDTO insertResponse = response.body();
                Log.d(">>>>>>>>>>>>>`TAG", "onResponse: " + insertResponse.getStatus());

                if(insertResponse.getStatus().equals("success")){
                    Toast.makeText(FormConfirmStudentActivity.this, "đăng kí thành công", Toast.LENGTH_SHORT).show();
                    edt_note.setText("");
                    tv_mucdich.setText("");
                    tv_xacnhan.setText("");
                    edt_sdt.setText("");

                }else {
                    Toast.makeText(FormConfirmStudentActivity.this, "đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<InsertStudentServiceResponseDTO> call, Throwable t) {
            Log.d(">>> insert failed", "onFailure: " + t.getMessage());
        }
    };
}
