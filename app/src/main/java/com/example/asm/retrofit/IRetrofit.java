package com.example.asm.retrofit;

import com.example.asm.api_res.CategoryRes;
import com.example.asm.api_res.LoginReq;
import com.example.asm.api_res.LoginRes;
import com.example.asm.api_res.NewsRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IRetrofit {
    @GET("/api/category/get_all_category.php")
    Call<CategoryRes> getAllCategory();

    // get all news
    @GET("/api/news/get_news.php")
    Call<NewsRes> getAllNews();

    @GET("/api/notification/get_notification_by_id.php")
    Call<NewsRes> getNotification(@Query("userId") String userId);

    @GET("/api/news/get_news_by_category.php")
    Call<NewsRes> getNewsByCategory(@Query("categoryId") int categoryId);

    @GET("/api/news/get_detail_news.php")
    Call<NewsRes> getDetailNews(@Query("newsId") int newsId);



    @POST("api/user/login.php")
    Call<LoginRes> login(@Body LoginReq body);
}
