package com.example.bfcfashion.module.fragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bfcfashion.module.fragments.KidsShopFragment;
import com.example.bfcfashion.module.fragments.MensShopFragment;
import com.example.bfcfashion.module.fragments.WomenShopFragment;

public class ShopPagerAdapter extends FragmentStateAdapter {
    public ShopPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new WomenShopFragment();
            case 1:
                return new MensShopFragment();
            case 2:
                return new KidsShopFragment();
            default:
                return new KidsShopFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
