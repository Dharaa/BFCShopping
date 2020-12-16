package com.example.bfcfashion.api;

import com.example.bfcfashion.auth.model.CategoryResponse;
import com.example.bfcfashion.auth.model.SignUpDetail;
import com.example.bfcfashion.auth.model.SignUpResponse;
import com.example.bfcfashion.module.model.login.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Auth {

    @Headers({"Content-Type: application/json"})
    @POST("?service=user-login&v=2.0&device-type=3.0")
    Call<LoginResponse> doLogin(@Header("auth-key") String header,
                                @Body RequestBody loginDetail);

    @POST("user/register")
    Call<SignUpResponse> doSignUp(@Body SignUpDetail signUpDetail);

    @POST("?service=catagories&v=2.0&device-type=3")
    Call<CategoryResponse> getCategories(@Header("auth-key") String header,
                                         @Body RequestBody categoryDetails);
}
