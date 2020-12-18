package com.example.bfcfashion.module.activity;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.api.ApiClient;
import com.example.bfcfashion.api.Auth;
import com.example.bfcfashion.common.AndyConstant;
import com.example.bfcfashion.module.fragment.adapter.ColorAdapter;
import com.example.bfcfashion.module.fragment.adapter.ProductDetailsSliderAdapter;
import com.example.bfcfashion.module.fragment.adapter.TrendingAdapter;
import com.example.bfcfashion.module.model.ColorsResponse.ColorsItem;
import com.example.bfcfashion.module.model.ColorsResponse.GetColorsResponse;
import com.example.bfcfashion.module.model.SliderItem;
import com.example.bfcfashion.module.model.TrendingItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView detailsPager;
    private ProductDetailsSliderAdapter productDetailsSliderAdapter;
    private List<SliderItem> sliderItems;
    private RecyclerView suggestionRecyclerView;
    private List<TrendingItem> trendingItemList;
    private TrendingAdapter trendingAdapter;
    private TextView tvSize, tvColors;
    List<ColorsItem> colorItemList=new ArrayList<>();
    private static final String TAG = "ProductDetail";

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
        tvColors = findViewById(R.id.tvColors);

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
        getColors();

        tvSize.setOnClickListener(this);
        tvColors.setOnClickListener(this);
    }

    private void setTrendingRecycler(List<TrendingItem> trendingItems) {
        suggestionRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        trendingAdapter = new TrendingAdapter(ProductDetailsActivity.this, trendingItems);
        suggestionRecyclerView.setAdapter(trendingAdapter);
        trendingAdapter.notifyDataSetChanged();

    }

    private void getColors() {
        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        Map<String, Object> jsonObjectCategories = new ArrayMap<>();
        jsonObjectCategories.put("device_id", "1");
        jsonObjectCategories.put("ip_address", "192.168.0.1");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonObjectCategories)).toString());

        Call<GetColorsResponse> call = auth.getColors(AndyConstant.header, body);
        call.enqueue(new Callback<GetColorsResponse>() {
            @Override
            public void onResponse(Call<GetColorsResponse> call, Response<GetColorsResponse> response) {
                Log.d(TAG, "onResponse: " + response.code() + " " + response.body().getMsg());
                if (response.body().isError()) {
                } else if (!response.body().isError()) {
                    colorItemList.addAll(response.body().getColor());
                    Log.d(TAG, "onResponse: " + "Category Data Found");
                } else {
                    Log.d(TAG, "onResponse: Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<GetColorsResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void setColorsRecyclerView(List<ColorsItem> categoryItemList) {

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
        if (v == tvColors) {
            if (colorItemList.size() > 0) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        ProductDetailsActivity.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.layout_color_bottom_sheet,
                                (LinearLayout) findViewById(R.id.bottomSheetContainer)
                        );
                RecyclerView colorListRv = bottomSheetView.findViewById(R.id.color_list);
//                colorListRv.setLayoutManager(new GridLayoutManager(this, 4));
                colorListRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                ColorAdapter colorAdapter = new ColorAdapter(ProductDetailsActivity.this, colorItemList);
                colorListRv.setAdapter(colorAdapter);
                colorAdapter.notifyDataSetChanged();

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        }
    }
}