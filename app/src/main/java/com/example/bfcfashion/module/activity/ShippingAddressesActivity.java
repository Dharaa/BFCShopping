package com.example.bfcfashion.module.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;

public class ShippingAddressesActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivAddAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_addresses);

        initViews();
    }

    private void initViews() {
        ivAddAddress = findViewById(R.id.ivAddAddress);

        ivAddAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ivAddAddress) {
            goToAddAddress();
        }
    }

    private void goToAddAddress() {
        Intent intent = new Intent(ShippingAddressesActivity.this, AddingShippingAddressActivity.class);
        startActivity(intent);
    }
}