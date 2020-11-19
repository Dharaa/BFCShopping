package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.SliderItem;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private Context context;
    private List<SliderItem> sliderItemList;
    private ViewPager2 viewPager2;

    public SliderAdapter(Context context, List<SliderItem> sliderItemList, ViewPager2 viewPager2) {
        this.context = context;
        this.sliderItemList = sliderItemList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapter.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_discover_banner, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderViewHolder holder, int position) {
        holder.ivSliderPhoto.setImageResource(sliderItemList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return sliderItemList.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivSliderPhoto;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSliderPhoto = itemView.findViewById(R.id.ivSliderPhoto);
        }
    }


}
