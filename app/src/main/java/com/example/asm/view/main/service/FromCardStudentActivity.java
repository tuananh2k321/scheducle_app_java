package com.example.asm.view.main.service;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm.R;
import com.example.asm.view.main.Interface.IRetrofit;
import com.example.asm.view.main.dto.InsertStudentServiceRequestDTO;
import com.example.asm.view.main.dto.InsertStudentServiceResponseDTO;
import com.example.asm.view.main.helper.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FromCardStudentActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton btn_img;
    Uri selectedImageUri;
    private TextView edt_sdt,edt_note;
    private Button btn_submit;
    IRetrofit iRetrofit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_card_student_activity);
        initView();


        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        // hiển thị nút back trên thanh toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một intent để mở bộ chọn ảnh
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = "Cấp thẻ sinh viên";
                String phoneNumber = edt_sdt.getText().toString();
                String note = edt_note.getText().toString();
                String img = String.valueOf(selectedImageUri);
                Log.d(">>>>>>TAG", "onClick: "+img);


                iRetrofit = RetrofitHelper.createService(IRetrofit.class);
                InsertStudentServiceRequestDTO insertStudentServiceRequestDTO = new InsertStudentServiceRequestDTO(service,img,"ps24412",phoneNumber,note,1);
                iRetrofit.insertStudent(insertStudentServiceRequestDTO).enqueue(insert);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Lấy đường dẫn của ảnh được chọn
            selectedImageUri = data.getData();

            // Tiếp theo, bạn có thể làm gì đó với đường dẫn ảnh được chọn, ví dụ:
            // - Hiển thị ảnh trong ImageView
            // - Lưu trữ đường dẫn để sử dụng sau này
            // - Tải ảnh lên máy chủ

            // Ví dụ: hiển thị ảnh trong ImageView
            btn_img.setImageURI(selectedImageUri);
        }
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
        btn_img = findViewById(R.id.btn_img);
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
                    startActivity(new Intent(FromCardStudentActivity.this, FromCardStudentActivity.class));
                    Toast.makeText(FromCardStudentActivity.this, "đăng kí thành công", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(FromCardStudentActivity.this, "đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<InsertStudentServiceResponseDTO> call, Throwable t) {
            Log.d(">>> insert failed", "onFailure: " + t.getMessage());
        }
    };
}
