package com.example.asm.view.main.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.asm.R;
import com.example.asm.api_res.NewsRes;
import com.example.asm.databinding.ActivityNewsDetailBinding;
import com.example.asm.model.News;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailActivity extends AppCompatActivity {
    // retrofit
    private IRetrofit iRetrofit;
    private ActivityNewsDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // retrofit
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        // back
        binding.cvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent receivedIntent = getIntent();
        int newsId = receivedIntent.getIntExtra("newsId", -1); // -1 là giá trị mặc định nếu không tìm thấy key
        Log.e("newsId news detail", ""+newsId);
        iRetrofit.getDetailNews(newsId).enqueue(newsResCallback);
    }

    private Callback<NewsRes> newsResCallback = new Callback<NewsRes>() {
        @Override
        public void onResponse(Call<NewsRes> call, Response<NewsRes> response) {
            NewsRes newsRes = response.body();
            if (newsRes != null) {
                if (newsRes.getStatus()) {
                    Log.e("newsResCallback", "newsResCallback: " + "success");
                    Log.e("newsResCallback", "newsResCallback: " + newsRes.toString());
                    News news = newsRes.getOneNews();
                    binding.tvTitle.setText(news.getTitle());
                    binding.tvDetail.setText(news.getDetail());
                    Glide.with(getApplicationContext())
                            .load(news.getImg())
                            .fitCenter()
                            .into(binding.imgNews)
                    ;
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