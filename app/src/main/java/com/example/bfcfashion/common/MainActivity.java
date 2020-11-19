package com.example.bfcfashion.common;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragments.BagFragment;
import com.example.bfcfashion.module.fragments.FavoriteFragment;
import com.example.bfcfashion.module.fragments.HomeFragment;
import com.example.bfcfashion.module.fragments.ProfileFragment;
import com.example.bfcfashion.module.fragments.ShopFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mainContent;
    private LinearLayout lvHome;
    private LinearLayout lvShop;
    private LinearLayout lvBag;
    private LinearLayout lvFav;
    private LinearLayout lvProfile;
    private ImageView ivHome;
    private ImageView ivShop;
    private ImageView ivBag;
    private ImageView ivFav;
    private ImageView ivProfile;
    private TextView tvHome;
    private TextView tvShop;
    private TextView tvBag;
    private TextView tvFav;
    private TextView tvProfile;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiViews();
    }

    private void intiViews() {
        mainContent = findViewById(R.id.mainContent);

        lvHome = findViewById(R.id.lvHome);
        ivHome = findViewById(R.id.ivHome);
        tvHome = findViewById(R.id.tvHome);

        lvShop = findViewById(R.id.lvShop);
        ivShop = findViewById(R.id.ivShop);
        tvShop = findViewById(R.id.tvShop);

        lvBag = findViewById(R.id.lvBag);
        ivBag = findViewById(R.id.ivBag);
        tvBag = findViewById(R.id.tvBag);

        lvFav = findViewById(R.id.lvFav);
        ivFav = findViewById(R.id.ivFav);
        tvFav = findViewById(R.id.tvFav);

        lvProfile = findViewById(R.id.lvProfile);
        ivProfile = findViewById(R.id.ivProfile);
        tvProfile = findViewById(R.id.tvProfile);

        lvHome.setOnClickListener(this);
        lvShop.setOnClickListener(this);
        lvBag.setOnClickListener(this);
        lvFav.setOnClickListener(this);
        lvProfile.setOnClickListener(this);

        homeSelected();
    }


    @Override
    public void onClick(View v) {
        if (v == lvHome) {
            favUnSelected();
            profileUnSelected();
            bagUnSelected();
            shopUnSelected();
            homeSelected();
            fragment = new HomeFragment();
            loadFragment(fragment);

        }
        if (v == lvFav) {
            homeUnselected();
            profileUnSelected();
            bagUnSelected();
            shopUnSelected();
            favSelected();
            fragment = new FavoriteFragment();
            loadFragment(fragment);

        }
        if (v == lvProfile) {
            profileSelected();
            homeUnselected();
            bagUnSelected();
            shopUnSelected();
            favUnSelected();
            fragment = new ProfileFragment();
            loadFragment(fragment);

        }
        if (v == lvBag) {
            bagSelected();
            homeUnselected();
            shopUnSelected();
            favUnSelected();
            profileUnSelected();
            fragment = new BagFragment();
            loadFragment(fragment);
            switchHome();
        }
        if (v == lvShop) {
            shopSelected();
            homeUnselected();
            bagUnSelected();
            favUnSelected();
            profileUnSelected();
            fragment = new ShopFragment();
            loadFragment(fragment);
            switchHome();
        }
    }

    private void switchHome() {
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return false;
    }

    private void homeSelected() {
        fragment = new HomeFragment();
        loadFragment(fragment);
        ivHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_selected));
        tvHome.setTextColor(getResources().getColor(R.color.blue));
    }

    private void homeUnselected() {
        ivHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_un_selected));
        tvHome.setTextColor(getResources().getColor(R.color.grey));
    }

    private void favSelected() {

        ivFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_fav_selected));
        tvFav.setTextColor(getResources().getColor(R.color.blue));

    }

    private void favUnSelected() {
        ivFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_fav_unselected));
        tvFav.setTextColor(getResources().getColor(R.color.grey));
    }

    private void profileSelected() {
        ivProfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_profile_selected));
        tvProfile.setTextColor(getResources().getColor(R.color.blue));
    }

    private void profileUnSelected() {
        ivProfile.setImageDrawable(getResources().getDrawable(R.drawable.ic_profile_unslected));
        tvProfile.setTextColor(getResources().getColor(R.color.grey));
    }

    private void bagSelected() {
        ivBag.setImageDrawable(getResources().getDrawable(R.drawable.ic_bag_selected));
        tvBag.setTextColor(getResources().getColor(R.color.blue));
    }

    private void bagUnSelected() {
        ivBag.setImageDrawable(getResources().getDrawable(R.drawable.ic_bag_unselected));
        tvBag.setTextColor(getResources().getColor(R.color.grey));
    }

    private void shopSelected() {
        ivShop.setImageDrawable(getResources().getDrawable(R.drawable.ic_cart_active));
        tvShop.setTextColor(getResources().getColor(R.color.blue));
    }

    private void shopUnSelected() {
        ivShop.setImageDrawable(getResources().getDrawable(R.drawable.ic_shopw_unselected));
        tvShop.setTextColor(getResources().getColor(R.color.grey));
    }
}