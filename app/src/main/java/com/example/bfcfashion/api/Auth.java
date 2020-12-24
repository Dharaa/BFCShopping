package com.example.bfcfashion.api;

import com.example.bfcfashion.auth.model.CreateProduct.CreateCategoryResponse;
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
    public static String CONTENT_TYPE = "Content-Type: application/json";
    public static String Register = "/api/?service=user-registration&v=2.0&device-type=3";
    public static String Login = "/api/?service=user-login&v=2.0&device-type=3.0";
    public static String CreateCategory = "/api/?service=create-catagory&v=2.0&device-type=3";
    public static String GetCategories = "/api/?service=catagories&v=2.0&device-type=3";
    public static String CreateBrands = "/api/?service=create-brands&v=2.0&device-type=3";
    public static String GetBrand = "/api/?service=brand&v=2.0&device-type=3";
    public static String CreateColors = "/api/?service=create-colors&v=2.0&device-type=3";
    public static String GetColors = "/api/?service=colors&v=2.0&device-type=3";
    public static String CreateSize = "/api/?service=create-size&&v=2.0&device-type=3";
    public static String CreateProducts = "/api/?service=create-products&&v=2.0&device-type=3";
        public static String Banners = "?Banners";
    public static String products = "?products";
    public static String ProductsBrands = "?product-brands";
        public static String ProductColorsImages = "?product-colors-images";

    //region
    @Headers({CONTENT_TYPE})
    @POST(Login)
    Call<LoginResponse> doLogin(@Header("auth-key") String header,
                                @Body RequestBody loginDetail);

    @Headers({CONTENT_TYPE})
    @POST(Register)
    Call<SignUpResponse> doSignUp(@Header("auth-key") String header,
                                  @Body RequestBody loginDetail);


//    @POST(CreateCategory)
//    Call<CreateCategoryResponse> callCreateCategory(@Header("auth-key") String header,
//                                            @Body RequestBody createCategory);


    @POST(GetCategories)
    Call<GetCategoryResponse> getCategories(@Header("auth-key") String header,
                                            @Body RequestBody categoryDetails);


//    @POST(CreateBrands)
//    Call<CreateBrandResponse> callCreateBrand(@Header("auth-key") String header,
//                                            @Body RequestBody createBrand);

    @POST(GetBrand)
    Call<GetBrandsResponse> getBrand(@Header("auth-key") String header,
                                     @Body RequestBody categoryDetails);

//    @POST(CreateColors)
//    Call<CreateColorsResponse> callCreateColors(@Header("auth-key") String header,
//                                            @Body RequestBody createColors);

    @POST(GetColors)
    Call<GetColorsResponse> getColors(@Header("auth-key") String header,
                                      @Body RequestBody ColorsDetail);

//    @POST(CreateSize)
//    Call<CreateSizeResponse> callCreateSize(@Header("auth-key") String header,
//                                            @Body RequestBody createSize);


    @POST(CreateProducts)
    Call<CreateCategoryResponse> callCreateProduct(@Header("auth-key") String header,
                                                   @Body RequestBody createCategory);

    @POST(Banners)
    Call<CreateCategoryResponse> callBanners(@Header("auth-key") String header,//optional
                                             @Body RequestBody banners);

    @POST(products)
    Call<CreateCategoryResponse> callProduct(@Header("auth-key") String header,//optional
                                             @Body RequestBody products);

    @POST(ProductsBrands)
    Call<CreateCategoryResponse> callProductBrands(@Header("auth-key") String header,//optional
                                                   @Body RequestBody product_brands);

    @POST(ProductColorsImages)
    Call<GetColorsResponse> callProductColorImage(@Header("auth-key") String header,
                                                  @Body RequestBody product_color_image);

}
