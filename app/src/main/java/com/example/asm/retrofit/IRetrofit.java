package com.example.asm.retrofit;

import com.example.asm.api_res.CategoryRes;
import com.example.asm.api_res.NewsRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRetrofit {
    @GET("/api/category/get_all_category.php")
    Call<CategoryRes> getAllCategory();

    // get all news
    @GET("/api/news/get_news.php")
    Call<NewsRes> getAllNews();

    @GET("/api/news/get_news_by_category.php")
    Call<NewsRes> getNewsByCategory(@Query("categoryId") int categoryId);

    @GET("/api/news/get_detail_news.php")
    Call<NewsRes> getDetailNews(@Query("newsId") int newsId);
}
