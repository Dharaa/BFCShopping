package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.WomensItem;

import java.util.List;

public class WomenShopAdapter extends RecyclerView.Adapter<WomenShopAdapter.WomenShopViewHolder> {
    private Context context;
    private List<WomensItem> womensItemList;

    public WomenShopAdapter(Context context, List<WomensItem> womensItemList) {
        this.context = context;
        this.womensItemList = womensItemList;
    }

    @NonNull
    @Override
    public WomenShopAdapter.WomenShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item_vp, parent, false);
        return new WomenShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WomenShopAdapter.WomenShopViewHolder holder, int position) {
        WomensItem womensItem = womensItemList.get(position);
        holder.ivItem.setImageResource(womensItem.getImageUrl());
        holder.tvItemName.setText(womensItem.getOutFitName());
    }

    @Override
    public int getItemCount() {
        return womensItemList.size();
    }

    public class WomenShopViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivItem;
        private TextView tvItemName;

        public WomenShopViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.ivItem);
            tvItemName = itemView.findViewById(R.id.tvItemName);
        }
    }
}
