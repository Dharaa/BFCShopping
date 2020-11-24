package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.SliderItem;

import java.util.List;

public class ProductDetailsSliderAdapter extends RecyclerView.Adapter<ProductDetailsSliderAdapter.ProductsDetailsVIewHolder> {
    private Context context;
    private List<SliderItem> sliderItems;


    public ProductDetailsSliderAdapter(Context context, List<SliderItem> sliderItems) {
        this.context = context;
        this.sliderItems = sliderItems;
    }


    @NonNull
    @Override
    public ProductDetailsSliderAdapter.ProductsDetailsVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_details_item_slider, parent, false);
        return new ProductsDetailsVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailsSliderAdapter.ProductsDetailsVIewHolder holder, int position) {
        holder.ivDetails.setImageResource(sliderItems.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class ProductsDetailsVIewHolder extends RecyclerView.ViewHolder {
        private ImageView ivDetails;

        public ProductsDetailsVIewHolder(@NonNull View itemView) {
            super(itemView);
            ivDetails = itemView.findViewById(R.id.ivDetails);
        }
    }
}
