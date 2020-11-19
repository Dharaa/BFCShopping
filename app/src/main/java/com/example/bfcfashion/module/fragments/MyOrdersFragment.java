package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bfcfashion.R;

public class MyOrdersFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tvDelivered;
    private TextView tvProcessing;
    private TextView tvCancelled;

    private LinearLayout lvDelivered;
    private LinearLayout lvProcessing;
    private LinearLayout lvCancelled;
    private Fragment fragment = null;

    public MyOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tvDelivered = view.findViewById(R.id.tvDelivered);
        tvProcessing = view.findViewById(R.id.tvProcessing);
        tvCancelled = view.findViewById(R.id.tvCancelled);

        lvDelivered = view.findViewById(R.id.lvDelivered);
        lvProcessing = view.findViewById(R.id.lvProcessing);
        lvCancelled = view.findViewById(R.id.lvCancelled);

        tvDelivered.setOnClickListener(this);
        tvProcessing.setOnClickListener(this);
        tvCancelled.setOnClickListener(this);
        switchDelivered();
    }


    @Override
    public void onClick(View v) {
        if (v == tvDelivered) {
            switchDelivered();

        }
        if (v == tvProcessing) {
            switchProcessing();

        }
        if (v == tvCancelled) {
            switchCancelled();

        }

    }

    private void switchProcessing() {

        tvProcessing.setBackground(getResources().getDrawable(R.drawable.tags_item_bg));
        tvProcessing.setTextColor(getResources().getColor(R.color.white));

        tvCancelled.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvCancelled.setTextColor(getResources().getColor(R.color.black));

        tvDelivered.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvDelivered.setTextColor(getResources().getColor(R.color.black));

        lvCancelled.setVisibility(View.GONE);
        lvDelivered.setVisibility(View.GONE);
        lvProcessing.setVisibility(View.VISIBLE);


    }


    private void switchCancelled() {

        tvCancelled.setBackground(getResources().getDrawable(R.drawable.tags_item_bg));
        tvCancelled.setTextColor(getResources().getColor(R.color.white));


        tvProcessing.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvProcessing.setTextColor(getResources().getColor(R.color.black));

        tvDelivered.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvDelivered.setTextColor(getResources().getColor(R.color.black));
        lvCancelled.setVisibility(View.VISIBLE);
        lvDelivered.setVisibility(View.GONE);
        lvProcessing.setVisibility(View.GONE);


    }

    private void switchDelivered() {
        tvDelivered.setBackground(getResources().getDrawable(R.drawable.tags_item_bg));
        tvDelivered.setTextColor(getResources().getColor(R.color.white));

        tvCancelled.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvCancelled.setTextColor(getResources().getColor(R.color.black));

        tvProcessing.setBackground(getResources().getDrawable(R.drawable.item_unselected));
        tvProcessing.setTextColor(getResources().getColor(R.color.black));

        lvCancelled.setVisibility(View.GONE);
        lvDelivered.setVisibility(View.VISIBLE);
        lvProcessing.setVisibility(View.GONE);



    }

}