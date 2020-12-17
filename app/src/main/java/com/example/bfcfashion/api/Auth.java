package com.example.bfcfashion.api;

import com.example.bfcfashion.module.model.ColorsResponse.GetColorsResponse;
import com.example.bfcfashion.module.model.GetBrand.GetBrandsResponse;
import com.example.bfcfashion.module.model.categoryResponse.GetCategoryResponse;
import com.example.bfcfashion.module.model.login.LoginResponse;
import com.example.bfcfashion.module.model.signup.SignUpResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Auth {
//region
    @Headers({"Content-Type: application/json"})
    @POST("?service=user-login&v=2.0&device-type=3.0")
    Call<LoginResponse> doLogin(@Header("auth-key") String header,
                                @Body RequestBody loginDetail);

    @Headers({"Content-Type: application/json"})
    @POST("?service=user-registration&v=2.0&device-type=3.0")
    Call<SignUpResponse> doSignUp(@Header("auth-key") String header,
                                  @Body RequestBody loginDetail);


//    @POST("?service=create-catagory&v=2.0&device-type=3")
//    Call<CreateCategoryResponse> callCreateCategory(@Header("auth-key") String header,
//                                            @Body RequestBody createCategory);


    @POST("?service=catagories&v=2.0&device-type=3")
    Call<GetCategoryResponse> getCategories(@Header("auth-key") String header,
                                            @Body RequestBody categoryDetails);


//    @POST("?service=create-brands&v=2.0&device-type=3")
//    Call<CreateBrandResponse> callCreateBrand(@Header("auth-key") String header,
//                                            @Body RequestBody createBrand);

    @POST("?service=brand&v=2.0&device-type=3")
    Call<GetBrandsResponse> getBrand(@Header("auth-key") String header,
                                     @Body RequestBody categoryDetails);

//    @POST("?service=create-colors&v=2.0&device-type=3")
//    Call<CreateColorsResponse> callCreateColors(@Header("auth-key") String header,
//                                            @Body RequestBody createColors);

    @POST("?service=colors&v=2.0&device-type=3")
    Call<GetColorsResponse> getColors(@Header("auth-key") String header,
                                      @Body RequestBody ColorsDetail);

//    @POST("?service=create-size&&v=2.0&device-type=3")
//    Call<CreateSizeResponse> callCreateSize(@Header("auth-key") String header,
//                                            @Body RequestBody createSize);

}
