package com.example.bfcfashion.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
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
import com.example.bfcfashion.common.MainActivity;
import com.example.bfcfashion.module.model.login.LoginResponse;
import com.shasin.notificationbanner.Banner;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
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
//            goToLogin();
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
        Map<String, Object> jsonObjectLogin = new ArrayMap<>();
        jsonObjectLogin.put("type_id", "1");
        jsonObjectLogin.put("mobile_email", email);
        jsonObjectLogin.put("password", password);
        jsonObjectLogin.put("device_id", "1");
        jsonObjectLogin.put("ip_address", "192.168.0.1");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonObjectLogin)).toString());

        Call<LoginResponse> call = auth.doLogin("WAq+1EQS1fke69TTQz3C22KAVBwxiAcpQudOr4DVpeI=",
                body);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.body().getMsg());
                if (response.body().isError()) {
                    Log.e(TAG, "onResponse: Invalid username or password");
                    Banner.make(rootview, getBaseContext(), Banner.ERROR, "Invalid username or password", Banner.BOTTOM, 2000).show();
                } else if (!response.body().isError()) {
                    Log.e(TAG, "onResponse: " + "User Found");
                    goToLogin();
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
        // finish();
    }

    private void goToForgotPasswordActivity() {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}