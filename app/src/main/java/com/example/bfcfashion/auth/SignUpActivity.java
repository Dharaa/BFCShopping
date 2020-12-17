package com.example.bfcfashion.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;
import com.example.bfcfashion.api.ApiClient;
import com.example.bfcfashion.api.Auth;
import com.example.bfcfashion.module.model.signup.SignUpResponse;
import com.shasin.notificationbanner.Banner;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLoginPage;
    private TextView tvSignUp;
    private static final String TAG = "SignUpActivity";
    private EditText etFullName;
    private EditText etEmail, etMobile;
    private EditText etPassword;
    private View rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rootview = findViewById(android.R.id.content);
        initViews();
    }

    public static void openActivityAndClearPreviousStack(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        clearActivityStack(intent);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == tvLoginPage) {
            goToLoginScreen();
        }
        if (v == tvSignUp) {
            doUIValidation();
//            goToLoginScreen();
        }

    }

    private static void clearActivityStack(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    private void initViews() {
        tvLoginPage = findViewById(R.id.tvLoginPage);
        tvSignUp = findViewById(R.id.tvSignUp);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);

        tvLoginPage.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
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
        String eMobile = etMobile.getText().toString();
        if (TextUtils.isEmpty(eMobile)) {
            etMobile.requestFocus();
            etMobile.setError("Enter Mobile number");
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
        goTOMain(fullName, email, password, eMobile);
    }

    private void goTOMain(String fullName, String email, String password, String etMobile) {
        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        //SignUpDetail signUpDetail = new SignUpDetail(fullName, email, password)
        Map<String, Object> jsonObjectLogin = new ArrayMap<>();
        jsonObjectLogin.put("type_id", "1");
        jsonObjectLogin.put("name", fullName);
        jsonObjectLogin.put("email", email);
        jsonObjectLogin.put("mobile", etMobile);
        jsonObjectLogin.put("password", password);
        jsonObjectLogin.put("confirm_password", password);
        jsonObjectLogin.put("device_id", "1");
        jsonObjectLogin.put("register_terms", "1");
        jsonObjectLogin.put("ip_address", "192.168.0.1");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonObjectLogin)).toString());
        Call<SignUpResponse> call = auth.doSignUp("WAq+1EQS1fke69TTQz3C22KAVBwxiAcpQudOr4DVpeI=", body);
        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.body() != null && response.body().isError()) {
                    Toast.makeText(SignUpActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                } else if (!response.body().isError()) {
                    Banner.make(rootview, getBaseContext(), Banner.SUCCESS, "Registration Successful",
                            Banner.BOTTOM, 2000).show();
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
//        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
//        startActivity(intent);
        openActivityAndClearPreviousStack(SignUpActivity.this, LoginActivity.class);
    }
}