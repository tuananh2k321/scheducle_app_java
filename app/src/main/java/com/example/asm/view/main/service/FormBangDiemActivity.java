package com.example.asm.view.main.service;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm.R;
import com.example.asm.view.main.Interface.IRetrofit;
import com.example.asm.view.main.dto.InsertBangDiemServiceRequestDTO;
import com.example.asm.view.main.dto.InsertStudentServiceResponseDTO;
import com.example.asm.view.main.helper.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormBangDiemActivity extends AppCompatActivity {

    private EditText edt_sl,edt_sdt,edt_note;
    private Button btn_submit;

    IRetrofit iRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_diemso_activity);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        // hiển thị nút back trên thanh toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initView();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = "Cấp bảng điểm";
                String studentCode = "ps12345";
                int quantity = Integer.parseInt(edt_sl.getText().toString());
                String note = edt_note.getText().toString();
                String phoneNumber = edt_sdt.getText().toString();
                iRetrofit = RetrofitHelper.createService(IRetrofit.class);
                InsertBangDiemServiceRequestDTO insertBangDiemServiceRequestDTO = new InsertBangDiemServiceRequestDTO(service,studentCode,phoneNumber,note,quantity);
                iRetrofit.insertBangDiem(insertBangDiemServiceRequestDTO).enqueue(insert);
            }
        });
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
        edt_sl = findViewById(R.id.tv_mucdich);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_note = findViewById(R.id.edt_note);
        btn_submit = findViewById(R.id.btn_submit);
    }

    Callback<InsertStudentServiceResponseDTO> insert = new Callback<InsertStudentServiceResponseDTO>() {
        @Override
        public void onResponse(Call<InsertStudentServiceResponseDTO> call, Response<InsertStudentServiceResponseDTO> response) {
            if (response.isSuccessful()){
                InsertStudentServiceResponseDTO insertResponse = response.body();
                Log.d(">>>>>>>>>>>>>`TAG", "onResponse: " + insertResponse.getStatus());

                if(insertResponse.getStatus().equals("success")){
                    Toast.makeText(FormBangDiemActivity.this, "đăng kí thành công", Toast.LENGTH_SHORT).show();
                    edt_note.setText("");
                    edt_sl.setText("");
                    edt_sdt.setText("");

                }else {
                    Toast.makeText(FormBangDiemActivity.this, "đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<InsertStudentServiceResponseDTO> call, Throwable t) {
            Log.d(">>> insert failed", "onFailure: " + t.getMessage());
        }
    };
}
