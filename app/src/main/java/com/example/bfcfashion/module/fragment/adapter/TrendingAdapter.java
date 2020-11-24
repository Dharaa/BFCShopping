package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.activity.ProductDetailsActivity;
import com.example.bfcfashion.module.model.TrendingItem;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder> {
    private Context context;
    private List<TrendingItem> trendingItemList;


    public TrendingAdapter(Context context, List<TrendingItem> trendingItemList) {
        this.context = context;
        this.trendingItemList = trendingItemList;
    }

    @NonNull
    @Override
    public TrendingAdapter.TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_item, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.TrendingViewHolder holder, int position) {
        holder.ivTrending.setImageResource(trendingItemList.get(position).getImageUrl());
        holder.tvProviderName.setText(trendingItemList.get(position).getTvProviderName());
        holder.tvTrendingDressName.setText(trendingItemList.get(position).getTvTrendingDressName());
        holder.tvTotalPrice.setText(trendingItemList.get(position).getTvTotalPrice());

        holder.lvTrendingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return trendingItemList.size();
    }

    public class TrendingViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivTrending;
        private TextView tvProviderName;
        private TextView tvTrendingDressName;
        private TextView tvTotalPrice;
        private LinearLayout lvTrendingItem;

        public TrendingViewHolder(@NonNull View itemView) {
            super(itemView);

            ivTrending = itemView.findViewById(R.id.ivTrending);
            tvProviderName = itemView.findViewById(R.id.tvProviderName);
            tvTrendingDressName = itemView.findViewById(R.id.tvTrendingDressName);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
            lvTrendingItem = itemView.findViewById(R.id.lvTrendingItem);
        }
    }
}
