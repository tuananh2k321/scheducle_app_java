package com.example.asm.view.main.service;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm.R;

public class FormStudentActivity extends AppCompatActivity {
    TextView edt_xacnhan,tv_mucdich;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_sinhvien_activity);
        tv_mucdich = findViewById(R.id.tv_mucdich);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        // hiển thị nút back trên thanh toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        builder = new AlertDialog.Builder(this);


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
    }

    // show dialog

    public void showItemSelectionDialog(View view) {
        builder
                .setItems(R.array.item_array1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.item_array1);
                        String selectedItem = items[which];
                         edt_xacnhan = findViewById(R.id.edt_xacnhan);
                        edt_xacnhan.setText(selectedItem);
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
}
