package com.example.bfcfashion.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLoginPage;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
    }

    private void initViews() {
        tvLoginPage = findViewById(R.id.tvLoginPage);
        tvSignUp = findViewById(R.id.tvSignUp);

        tvLoginPage.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvLoginPage) {
            goToLoginScreen();
        }
        if (v == tvSignUp) {
            goToLoginScreen();
        }

    }

    private void goToLoginScreen() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}