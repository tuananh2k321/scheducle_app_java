package com.example.asm.view.main.helpers;

import com.example.asm.view.main.dto.SchedulesResponeDTO;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface IRetrofitInterface {
    @GET("/api/schedule/get-schedules.php")
    Call<SchedulesResponeDTO> getSchedules(@QueryMap Map<String, String> queries);
}
