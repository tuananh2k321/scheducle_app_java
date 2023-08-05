package com.example.asm.view.main.Interface;
import com.example.asm.view.main.dto.GetAllServiceCompleteResponseDTO;
import com.example.asm.view.main.dto.InsertBangDiemServiceRequestDTO;
import com.example.asm.view.main.dto.InsertConfirmStudentServiceRequestDTO;
import com.example.asm.view.main.dto.InsertStudentServiceRequestDTO;
import com.example.asm.view.main.dto.InsertStudentServiceResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IRetrofit {

    @POST("/api/services/insert_student_service.php")
    Call<InsertStudentServiceResponseDTO> insertStudent(@Body InsertStudentServiceRequestDTO body);

    @POST("/api/services/insert_bandiem_service.php")
    Call<InsertStudentServiceResponseDTO> insertBangDiem(@Body InsertBangDiemServiceRequestDTO body);

    @POST("/api/services/insert_confirm_service.php")
    Call<InsertStudentServiceResponseDTO> insertConfirm(@Body InsertConfirmStudentServiceRequestDTO body);

    @GET("/api/services/get_all_service_complete.php")
    Call<GetAllServiceCompleteResponseDTO> getAllServiceComplete();


}
