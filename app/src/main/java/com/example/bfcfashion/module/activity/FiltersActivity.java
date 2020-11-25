package com.example.bfcfashion.module.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;
import com.google.android.material.slider.RangeSlider;

public class FiltersActivity extends AppCompatActivity implements View.OnClickListener {
    private RangeSlider rangeSlider;
    private TextView minPrice;
    private TextView maxPrice;
    private int min_p = 0;
    private int max_p = 0;
    private LinearLayout lvBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        initViews();
    }

    private void initViews() {
        rangeSlider = findViewById(R.id.rangeSlider);
        minPrice = findViewById(R.id.minPrice);
        maxPrice = findViewById(R.id.maxPrice);
        lvBrand = findViewById(R.id.lvBrand);


        rangeSlider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull RangeSlider slider) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                Float valueFrom = slider.getValues().get(0);
                Float valueto = slider.getValues().get(1);


                minPrice.setText("$" + Float.toString(valueFrom));
                maxPrice.setText("$" + Float.toString(valueto));
            }
        });

        lvBrand.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == lvBrand) {
            goToBrandActivity();
        }
    }

    private void goToBrandActivity() {
        Intent intent = new Intent(FiltersActivity.this, BrandActivity.class);
        startActivity(intent);
    }
}