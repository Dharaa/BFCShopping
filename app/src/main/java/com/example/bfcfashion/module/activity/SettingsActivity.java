package com.example.bfcfashion.module.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfcfashion.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();
    }

    private void initViews() {
        tvChange = findViewById(R.id.tvChange);

        tvChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                SettingsActivity.this, R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(
                        R.layout.layout_password_bottom_sheet,
                        (LinearLayout) findViewById(R.id.bottomSheetContainer)
                );
        bottomSheetView.findViewById(R.id.etOldPassword);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}