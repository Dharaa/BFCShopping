package com.example.bfcfashion.module.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.activity.SettingsActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout lhSettings;
    private LinearLayout lvMyOrders;
    private Fragment fragment = null;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews();
        return view;

    }

    private void initViews() {
        lhSettings = view.findViewById(R.id.lhSettings);
        lvMyOrders = view.findViewById(R.id.lvMyOrders);

        lhSettings.setOnClickListener(this);
        lvMyOrders.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == lhSettings) {
            goToSettings();
        }
        if (v == lvMyOrders) {
            switchHomeFragment();
        }
    }

    private void switchHomeFragment() {
        fragment = new MyOrdersFragment();
        loadFragment(fragment);
    }

    private void goToSettings() {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        getContext().startActivity(intent);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return false;
    }
}