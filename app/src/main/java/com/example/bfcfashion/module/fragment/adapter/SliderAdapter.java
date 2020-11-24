package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.SliderItem;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    List<SliderItem> sliderItems;
    Context context;

    public SliderAdapter(List<SliderItem> sliderItems, Context context) {
        this.sliderItems = sliderItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_discover_banner, null);
        ImageView image = view.findViewById(R.id.ivSliderPhoto);
        image.setImageResource(sliderItems.get(position).getImageUrl());


        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
