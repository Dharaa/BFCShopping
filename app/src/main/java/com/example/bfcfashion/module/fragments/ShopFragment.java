package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.ShopPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ShopFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ViewPager2 shopViewPager;
    private TabLayout tabLayout;
    private ImageView ivSearch;
    private Fragment fragment = null;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        shopViewPager = view.findViewById(R.id.shopViewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        ivSearch = view.findViewById(R.id.ivSearch);

        shopViewPager.setAdapter(new ShopPagerAdapter(getActivity()));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, shopViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("WOMEN");
                        break;
                    }
                    case 1: {
                        tab.setText("MEN");
                        break;
                    }
                    case 2: {
                        tab.setText("KIDS");
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();

        ivSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ivSearch) {
            openSearchFragment();
        }
    }

    private void openSearchFragment() {
        fragment = new SearchFragment();
        loadFragment(fragment);
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