package com.example.asm.view.main.service;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.asm.R;


import com.example.asm.view.main.Adapter.Servicee;
import com.example.asm.view.main.Interface.IRetrofit;
import com.example.asm.view.main.dto.GetAllServiceCompleteResponseDTO;
import com.example.asm.view.main.helper.RetrofitHelper;
import com.example.asm.view.main.model.ServiceComplete;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCompleteAcctivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imgback;

    private Servicee serviceCompleteAdapter2;
    IRetrofit iRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_complete_activity);
         recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        imgback = findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iRetrofit.getAllServiceComplete().enqueue(getAllServiceComplete);
    }

    Callback<GetAllServiceCompleteResponseDTO> getAllServiceComplete = new Callback<GetAllServiceCompleteResponseDTO>() {
        @Override
        public void onResponse(Call<GetAllServiceCompleteResponseDTO> call, Response<GetAllServiceCompleteResponseDTO> response) {
            if (response.isSuccessful()){
                GetAllServiceCompleteResponseDTO products = response.body();
                Log.d(">>>>>TAG", "onResponse: " +products.getStatus());
                if(products.getStatus().equals("success")){
                    Log.d(">>>>>>>>TAG", "onResponse: " + products.getList());
                    List<ServiceComplete> list = products.getList();
                    Log.d(">>>>>>>> list TAG", "onResponse: " + list);
                    serviceCompleteAdapter2 = new Servicee(getApplicationContext(), list);
                    recyclerView.setAdapter(serviceCompleteAdapter2);
                }


            }
        }

        @Override
        public void onFailure(Call<GetAllServiceCompleteResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };
}
