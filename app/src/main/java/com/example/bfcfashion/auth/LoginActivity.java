package com.example.bfcfashion.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;
import com.example.bfcfashion.api.ApiClient;
import com.example.bfcfashion.api.Auth;
import com.example.bfcfashion.auth.model.LoginDetail;
import com.example.bfcfashion.auth.model.LoginResponse;
import com.example.bfcfashion.common.MainActivity;
import com.shasin.notificationbanner.Banner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvForgotPassword;
    private TextView tvLogin;
    private static final String TAG = "LoginActivity";
    private EditText etEmail;
    private EditText etPassword;
    private View rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        rootview = findViewById(android.R.id.content);
    }

    private void initViews() {
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvLogin = findViewById(R.id.tvLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        tvForgotPassword.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvForgotPassword) {
            goToForgotPasswordActivity();
        }
        if (v == tvLogin) {
            doUIValidation();
        }

    }

    private void doUIValidation() {
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError("Email Required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            etEmail.requestFocus();
            return;
        }
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            etPassword.requestFocus();
            etPassword.setError("Password Required");
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Password should be atleast 6 character long");
            etPassword.requestFocus();
            return;
        }
        goToMain(email, password);
    }

    private void goToMain(String email, String password) {

        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        LoginDetail loginDetail = new LoginDetail(email, password);
        Call<LoginResponse> call = auth.doLogin(loginDetail);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.body().getMessage());
                if (response.body().getStatus() == 200) {
                    Log.e(TAG, "onResponse: " + "User Found");
                    goToLogin();
                } else if (response.body().getStatus() == 201) {
                    Log.e(TAG, "onResponse: Invalid username or password");
                    Banner.make(rootview, getBaseContext(), Banner.ERROR, "Invalid username or password", Banner.BOTTOM, 2000).show();
                } else {
                    Log.e(TAG, "onResponse: Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void goToLogin() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Banner.make(rootview, getBaseContext(), Banner.SUCCESS, "Login Successful", Banner.BOTTOM, 2000).show();
        startActivity(intent);
        finish();
    }

    private void goToForgotPasswordActivity() {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}