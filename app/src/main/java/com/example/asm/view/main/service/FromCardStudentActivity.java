package com.example.asm.view.main.service;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm.R;

public class FromCardStudentActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton btn_img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_card_student_activity);
        btn_img = findViewById(R.id.btn_img);

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
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Lấy đường dẫn của ảnh được chọn
            Uri selectedImageUri = data.getData();

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
}
