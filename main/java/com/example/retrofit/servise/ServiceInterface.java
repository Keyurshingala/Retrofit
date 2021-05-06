package com.example.retrofit.servise;

import com.example.retrofit.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("users")
    Call<ApiResponse> getResponse(@Query("page") int groupId);

}
