package com.example.serverdrivenuiapplication.network;

import com.example.serverdrivenuiapplication.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
//    public static String CREATION = "https://api-staging.bankaks.com/";

    @GET("task/{type}")
    Call<DataResponse> getType(@Path("type") int type);
}
