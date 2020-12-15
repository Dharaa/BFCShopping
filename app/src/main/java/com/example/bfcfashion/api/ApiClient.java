package com.example.bfcfashion.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //    private static final String BASE_URL = "http://bfc-fashion.astechnolabs.com/api/index.php/";
    private static final String BASE_URL = "http://www.astechnolabs.com/api-bfc-fashion.astechnolabs.com/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
           /* Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                    .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                    .readTimeout(5, TimeUnit.MINUTES); // read timeout
            OkHttpClient client = builder.addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
