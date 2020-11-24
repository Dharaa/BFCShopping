package com.example.bfcfashion.api;

import com.example.bfcfashion.auth.model.LoginDetail;
import com.example.bfcfashion.auth.model.LoginResponse;
import com.example.bfcfashion.auth.model.SignUpDetail;
import com.example.bfcfashion.auth.model.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Auth {


    @POST("auth/login")
    Call<LoginResponse> doLogin(@Body LoginDetail loginDetail);

    @POST("user/register")
    Call<SignUpResponse> doSignUp(@Body SignUpDetail signUpDetail);
}
