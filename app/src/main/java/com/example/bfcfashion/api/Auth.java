package com.example.bfcfashion.api;

import com.example.bfcfashion.module.model.login.LoginResponse;
import com.example.bfcfashion.module.model.signup.SignUpResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Auth {

    @Headers({"Content-Type: application/json"})
    @POST("?service=user-login&v=2.0&device-type=3.0")
    Call<LoginResponse> doLogin(@Header("auth-key") String header,
                                @Body RequestBody loginDetail);

    @Headers({"Content-Type: application/json"})
    @POST("?service=user-registration&v=2.0&device-type=3.0")
    Call<SignUpResponse> doSignUp(@Header("auth-key") String header,
                                  @Body RequestBody loginDetail);
}
