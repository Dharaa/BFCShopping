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
import com.example.bfcfashion.auth.model.SignUpDetail;
import com.example.bfcfashion.auth.model.SignUpResponse;
import com.shasin.notificationbanner.Banner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLoginPage;
    private TextView tvSignUp;
    private static final String TAG = "SignUpActivity";
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private View rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rootview = findViewById(android.R.id.content);
        initViews();
    }

    private void initViews() {
        tvLoginPage = findViewById(R.id.tvLoginPage);
        tvSignUp = findViewById(R.id.tvSignUp);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        tvLoginPage.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvLoginPage) {
            goToLoginScreen();
        }
        if (v == tvSignUp) {
//            doUIValidation();
            goToLoginScreen();
        }

    }

    private void doUIValidation() {
        String fullName = etFullName.getText().toString();
        if (TextUtils.isEmpty(fullName)) {
            etFullName.requestFocus();
            etFullName.setError("Enter Full Name");
            return;
        }
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError("Enter Email");
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
        goTOMain(fullName, email, password);
    }

    private void goTOMain(String fullName, String email, String password) {
        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        SignUpDetail signUpDetail = new SignUpDetail(fullName, email, password);
        Call<SignUpResponse> call = auth.doSignUp(signUpDetail);
        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.body().getStatus() == 201) {
                    Banner.make(rootview, getBaseContext(), Banner.SUCCESS, "Login Successful", Banner.BOTTOM, 2000).show();
                    goToLoginScreen();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void goToLoginScreen() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);

        startActivity(intent);
    }
}