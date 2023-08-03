package com.example.asm.view.main.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.asm.api_res.NewsRes;
import com.example.asm.databinding.ActivityNewsListBinding;
import com.example.asm.model.News;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity implements Listener {
    // retrofit
    private IRetrofit iRetrofit;
    private ActivityNewsListBinding binding;
    private ArrayList<News> newsList;
    private NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // retrofit
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        // back
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // news list
        Intent receivedIntent = getIntent();
        int categoryId = receivedIntent.getIntExtra("categoryId", -1); // -1 là giá trị mặc định nếu không tìm thấy key
        Log.e("categoryId news list", ""+categoryId);
        String categoryName = receivedIntent.getStringExtra("categoryName");
        binding.tvTitle.setText(categoryName);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rcvNews.setLayoutManager(layoutManager);
        iRetrofit.getNewsByCategory(categoryId).enqueue(newsResCallback);
    }


    private Callback<NewsRes> newsResCallback = new Callback<NewsRes>() {
        @Override
        public void onResponse(Call<NewsRes> call, Response<NewsRes> response) {
            NewsRes newsRes = response.body();
            if (newsRes != null) {
                if (newsRes.getStatus()) {
                    Log.e("newsResCallback", "newsResCallback: " + "success");
                    Log.e("newsResCallback", "newsResCallback: " + newsRes.toString());
                    newsList = newsRes.getNews();
                    newsAdapter = new NewsAdapter(getApplicationContext(), newsList, NewsListActivity.this);
                    binding.rcvNews.setAdapter(newsAdapter);
                } else {
                    Log.e("newsResCallback", "newsResCallback: " + "fail");
                }
            }
        }

        @Override
        public void onFailure(Call<NewsRes> call, Throwable t) {
            Log.e("newsResCallback", "onFailure: " + t.getMessage());
        }
    };
}