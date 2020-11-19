package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.DealsItem;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.DealsViewHolder> {
    private final Context context;
    private final List<DealsItem> dealsList;

    public DealsAdapter(Context context, List<DealsItem> dealsList) {
        this.context = context;
        this.dealsList = dealsList;
    }

    @NonNull
    @Override
    public DealsAdapter.DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.deals_layout_item, parent, false);
        return new DealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.DealsViewHolder holder, int position) {
        DealsItem dealsItem = dealsList.get(position);
        holder.ivDeals.setImageResource(dealsItem.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return dealsList.size();
    }

    public static class DealsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivDeals;

        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDeals = itemView.findViewById(R.id.ivDeals);
        }
    }
}
