package com.example.bfcfashion.module.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;

public class CheckOutActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvSubmitOrder, mTvChangeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        initViews();
    }

    private void initViews() {
        tvSubmitOrder = findViewById(R.id.tvSubmitOrder);
        mTvChangeAddress = findViewById(R.id.mTvChangeAddress);

        tvSubmitOrder.setOnClickListener(this);
        mTvChangeAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mTvChangeAddress) {
            goToSubmitOrder();
        }
    }

    private void goToSubmitOrder() {
        Intent intent = new Intent(CheckOutActivity.this, ShippingAddressesActivity.class);
        startActivity(intent);
    }
}