package com.example.asm.retrofit;

import com.example.asm.api_res.CategoryRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {
    @GET("/api/category/get_all_category.php")
    Call<CategoryRes> getAllCategory();
}
