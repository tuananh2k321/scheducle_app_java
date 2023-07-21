package com.example.asm.view.main.service;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.Adapter.ServiceCompleteAdapter;
import com.example.asm.view.main.model.ServiceComplete;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompleteAcctivity extends AppCompatActivity {
    private List<ServiceComplete> itemList;
    private ServiceCompleteAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_complete_activity);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemList = new ArrayList<>();
        // Thêm các mục dữ liệu vào danh sách
        itemList.add(new ServiceComplete("89123", "Cấp thẻ sinh viên", "More info 11111","của nhà trường","ngày 10/11/2023"));
        itemList.add(new ServiceComplete("89123", "Cấp thẻ sinh viên", "More info 11111How to add Shadow effect in TextView in Android Studio","của nhà trường","ngày 10/11/2023"));
        itemList.add(new ServiceComplete("89123", "Cấp thẻ sinh viên", "More info 11111","của nhà trường","ngày 10/11/2023"));
        itemList.add(new ServiceComplete("89123", "Cấp thẻ sinh viên", "More info 11111How to add Shadow effect in TextView in Android Studio","của nhà trường","ngày 10/11/2023"));
        itemList.add(new ServiceComplete("89123", "Cấp thẻ sinh viên", "More info 11111","của nhà trường","ngày 10/11/2023"));
        // ...

        adapter = new ServiceCompleteAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
