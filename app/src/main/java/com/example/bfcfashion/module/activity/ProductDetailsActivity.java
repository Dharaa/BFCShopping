package com.example.bfcfashion.module.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.ProductDetailsSliderAdapter;
import com.example.bfcfashion.module.fragment.adapter.TrendingAdapter;
import com.example.bfcfashion.module.model.SliderItem;
import com.example.bfcfashion.module.model.TrendingItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView detailsPager;
    private ProductDetailsSliderAdapter productDetailsSliderAdapter;
    private List<SliderItem> sliderItems;
    private RecyclerView suggestionRecyclerView;
    private List<TrendingItem> trendingItemList;
    private TrendingAdapter trendingAdapter;
    private TextView tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initViews();
    }

    private void initViews() {
        detailsPager = findViewById(R.id.detailsPager);
        suggestionRecyclerView = findViewById(R.id.suggestionRecyclerView);
        tvSize = findViewById(R.id.tvSize);

        detailsPager.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.details_one));
        sliderItems.add(new SliderItem(R.drawable.details_two));

        sliderItems.add(new SliderItem(R.drawable.details_one));
        sliderItems.add(new SliderItem(R.drawable.details_two));

        sliderItems.add(new SliderItem(R.drawable.details_one));
        sliderItems.add(new SliderItem(R.drawable.details_two));

        sliderItems.add(new SliderItem(R.drawable.details_one));

        productDetailsSliderAdapter = new ProductDetailsSliderAdapter(ProductDetailsActivity.this, sliderItems);
        detailsPager.setAdapter(productDetailsSliderAdapter);
        productDetailsSliderAdapter.notifyDataSetChanged();


        trendingItemList = new ArrayList<>();
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$20"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$30"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$40"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$50"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$60"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$70"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$80"));

        setTrendingRecycler(trendingItemList);

        tvSize.setOnClickListener(this);
    }

    private void setTrendingRecycler(List<TrendingItem> trendingItems) {
        suggestionRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        trendingAdapter = new TrendingAdapter(ProductDetailsActivity.this, trendingItems);
        suggestionRecyclerView.setAdapter(trendingAdapter);
        trendingAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if (v == tvSize) {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    ProductDetailsActivity.this, R.style.BottomSheetDialogTheme
            );
            View bottomSheetView = LayoutInflater.from(getApplicationContext())
                    .inflate(
                            R.layout.layout_size_bottom_sheet,
                            (LinearLayout) findViewById(R.id.bottomSheetContainer)
                    );
            //bottomSheetView.findViewById(R.id.etOldPassword);
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        }
    }
}