package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bfcfashion.R;
import com.example.bfcfashion.api.ApiClient;
import com.example.bfcfashion.api.Auth;
import com.example.bfcfashion.common.AndyConstant;
import com.example.bfcfashion.module.fragment.adapter.DealsAdapter;
import com.example.bfcfashion.module.fragment.adapter.HomeAdapter;
import com.example.bfcfashion.module.fragment.adapter.KidAdapter;
import com.example.bfcfashion.module.fragment.adapter.MensAdapter;
import com.example.bfcfashion.module.fragment.adapter.NewAdapter;
import com.example.bfcfashion.module.fragment.adapter.SliderAdapter;
import com.example.bfcfashion.module.fragment.adapter.TrendingAdapter;
import com.example.bfcfashion.module.fragment.adapter.WomenAdapter;
import com.example.bfcfashion.module.model.DealsItem;
import com.example.bfcfashion.module.model.GetBrand.BrandItem;
import com.example.bfcfashion.module.model.GetBrand.GetBrandsResponse;
import com.example.bfcfashion.module.model.KidItem;
import com.example.bfcfashion.module.model.MensItem;
import com.example.bfcfashion.module.model.NewItem;
import com.example.bfcfashion.module.model.SliderItem;
import com.example.bfcfashion.module.model.TrendingItem;
import com.example.bfcfashion.module.model.WomensItem;
import com.example.bfcfashion.module.model.categoryResponse.CatagoriesItem;
import com.example.bfcfashion.module.model.categoryResponse.GetCategoryResponse;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView categoryItemRecyclerView;
    private RecyclerView trendingNowRecyclerView;
    private RecyclerView dealsRecyclerView;
    private RecyclerView newRecyclerView;
    private RecyclerView mensRecyclerView;
    private RecyclerView womenRecyclerView;
    private RecyclerView kidsRecyclerView;
    private HomeAdapter homeAdapter;
    private View view;

    private ImageSlider slider;

    private Timer sliderTimer;
    List<CatagoriesItem> categoryItemList;
    List<BrandItem> brandsItemList;
    private ViewPager viewPager;
    private TabLayout tabs;
    private SliderAdapter adapter;
    private static final String TAG = "HomeFragment";

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        categoryItemRecyclerView = view.findViewById(R.id.categoryItemRecyclerView);
        trendingNowRecyclerView = view.findViewById(R.id.trendingNowRecyclerView);
        newRecyclerView = view.findViewById(R.id.newRecyclerView);
        dealsRecyclerView = view.findViewById(R.id.dealsRecyclerView);
        mensRecyclerView = view.findViewById(R.id.mensRecyclerView);
        womenRecyclerView = view.findViewById(R.id.womenRecyclerView);
        kidsRecyclerView = view.findViewById(R.id.kidsRecyclerView);

        slider = view.findViewById(R.id.slider);

        List<SliderItem> sliderItemList = new ArrayList<>();
        categoryItemList = new ArrayList<>();
        brandsItemList = new ArrayList<>();
//        viewPager = view.findViewById(R.id.viewPager);
//
//        layoutSliderIndicators = view.findViewById(R.id.layoutSliderIndicators);

        List<SlideModel> sliderItems = new ArrayList<>();
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));
        sliderItems.add(new SlideModel(R.drawable.image_slider, ScaleTypes.FIT));

        slider.setImageList(sliderItems, ScaleTypes.CENTER_CROP);

//        Timer timer = new Timer();
//        timer.schedule(new sliderTimer(), 4000, 6000);


        /*List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(R.drawable.men, "Men"));
        categoryItemList.add(new CategoryItem(R.drawable.men, "Women"));
        categoryItemList.add(new CategoryItem(R.drawable.men, "Kids"));
        categoryItemList.add(new CategoryItem(R.drawable.men, "Accessories"));
        setCategoryRecyclerView(categoryItemList);*/


        List<TrendingItem> trendingItemList = new ArrayList<>();
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$20"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$30"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$40"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$50"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$60"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$70"));
        trendingItemList.add(new TrendingItem(R.drawable.trending_item, "Dorothy Perkins", "Evening Dress", "$80"));

        setTrendingRecycler(trendingItemList);

        List<DealsItem> dealsItemList = new ArrayList<>();
        dealsItemList.add(new DealsItem(R.drawable.under_199));
        dealsItemList.add(new DealsItem(R.drawable.under299));
        dealsItemList.add(new DealsItem(R.drawable.under_499));
        setDealsRecycler(dealsItemList);

        List<NewItem> newItemList = new ArrayList<>();
        newItemList.add(new NewItem(R.drawable.new_one, "OVS", "Blouse", "$12"));
        newItemList.add(new NewItem(R.drawable.new_two, "Mango Boy", "T-Shirt Sailing", "$20"));
        newItemList.add(new NewItem(R.drawable.new_two, "Cool", "Jeans", "$12"));
        setNewRecycler(newItemList);

        List<MensItem> mensItemList = new ArrayList<>();
        mensItemList.add(new MensItem(R.drawable.mens_one, "Formal Shirts"));
        mensItemList.add(new MensItem(R.drawable.mens_two, "Party Wear"));
        mensItemList.add(new MensItem(R.drawable.mens_three, "Marriage Special"));
        setMensRecyclerView(mensItemList);

        List<WomensItem> womensItemList = new ArrayList<>();
        womensItemList.add(new WomensItem(R.drawable.women_one, "Kurta"));
        womensItemList.add(new WomensItem(R.drawable.women_two, "Saree"));
        womensItemList.add(new WomensItem(R.drawable.women_three, "Off Shoulder"));
        setWomenRecyclerView(womensItemList);

        List<KidItem> kidItemList = new ArrayList<>();
        kidItemList.add(new KidItem(R.drawable.kids_one, "Full Suit"));
        kidItemList.add(new KidItem(R.drawable.kids_one, "Coat"));
        kidItemList.add(new KidItem(R.drawable.kids_one, "Pent"));
        setKidsRecyclerView(kidItemList);

        /*Get Categories from network call*/
        getCategories();
        getBrand();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void setCategoryRecyclerView(List<CatagoriesItem> categoryItems) {
        categoryItemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        homeAdapter = new HomeAdapter(getContext(), categoryItems);
        categoryItemRecyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
    }


    private void setTrendingRecycler(List<TrendingItem> trendingItems) {
        trendingNowRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        TrendingAdapter trendingAdapter = new TrendingAdapter(getContext(), trendingItems);
        trendingNowRecyclerView.setAdapter(trendingAdapter);
        trendingAdapter.notifyDataSetChanged();

    }

    private void setDealsRecycler(List<DealsItem> dealsItems) {
        dealsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        DealsAdapter dealsAdapter = new DealsAdapter(getContext(), dealsItems);
        dealsRecyclerView.setAdapter(dealsAdapter);
        dealsAdapter.notifyDataSetChanged();
    }

    private void setNewRecycler(List<NewItem> newItems) {
        newRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        NewAdapter newAdapter = new NewAdapter(getContext(), newItems);
        newRecyclerView.setAdapter(newAdapter);
        newAdapter.notifyDataSetChanged();
    }

    private void setMensRecyclerView(List<MensItem> mensItems) {
        mensRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        MensAdapter mensAdapter = new MensAdapter(getContext(), mensItems);
        mensRecyclerView.setAdapter(mensAdapter);
        mensAdapter.notifyDataSetChanged();
    }

    private void setWomenRecyclerView(List<WomensItem> womensItems) {
        womenRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        WomenAdapter womenAdapter = new WomenAdapter(getContext(), womensItems);
        womenRecyclerView.setAdapter(womenAdapter);
        womenAdapter.notifyDataSetChanged();
    }

    private void setKidsRecyclerView(List<KidItem> kidItems) {
        kidsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        KidAdapter kidAdapter = new KidAdapter(getContext(), kidItems);
        kidsRecyclerView.setAdapter(kidAdapter);
        kidAdapter.notifyDataSetChanged();
    }

    private void getCategories() {
        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        Map<String, Object> jsonObjectCategories = new ArrayMap<>();
        jsonObjectCategories.put("main_category", 0);
        jsonObjectCategories.put("device_id", "1");
        jsonObjectCategories.put("ip_address", "192.168.0.1");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonObjectCategories)).toString());

        Call<GetCategoryResponse> call = auth.getCategories(AndyConstant.header, body);
        call.enqueue(new Callback<GetCategoryResponse>() {
            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> response) {
                Log.d(TAG, "onResponse: " + response.code() + " " + response.body().getMsg());
                if (response.body().isError()) {
                } else if (!response.body().isError()) {
                    categoryItemList.addAll(response.body().getCatagories());
                    if (categoryItemList.size() > 0) {
                        setCategoryRecyclerView(categoryItemList);
                    }
                    Log.d(TAG, "onResponse: " + "Category Data Found");
                } else {
                    Log.d(TAG, "onResponse: Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void getBrand() {
        Auth auth = ApiClient.getRetrofitInstance().create(Auth.class);
        Map<String, Object> jsonObjectCategories = new ArrayMap<>();
        jsonObjectCategories.put("device_id", "1");
        jsonObjectCategories.put("ip_address", "192.168.0.1");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonObjectCategories)).toString());

        Call<GetBrandsResponse> call = auth.getBrand(AndyConstant.header, body);
        call.enqueue(new Callback<GetBrandsResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetBrandsResponse> call, @NotNull Response<GetBrandsResponse> response) {
                Log.d(TAG, "onResponse: " + response.code() + " " + response.body().getMsg());
                if (response.body().isError()) {
                } else if (!response.body().isError()) {
                    brandsItemList.addAll(response.body().getBrand());
                    if (categoryItemList.size() > 0) {
                        setCategoryRecyclerView(categoryItemList);
                    }
                    Log.d(TAG, "onResponse: " + "Category Data Found");
                } else {
                    Log.d(TAG, "onResponse: Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<GetBrandsResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}