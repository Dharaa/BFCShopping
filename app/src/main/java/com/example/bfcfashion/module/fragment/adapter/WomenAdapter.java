package com.example.bfcfashion.module.fragment.adapter;

import android.annotation.SuppressLint;
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

public class WomenAdapter extends RecyclerView.Adapter<WomenAdapter.WomenViewHolder> {
    private final Context context;
    private final List<WomensItem> womensItemList;

    public WomenAdapter(Context context, List<WomensItem> womensItemList) {
        this.context = context;
        this.womensItemList = womensItemList;
    }

    @NonNull
    @Override
    public WomenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mens_item, parent, false);
        return new WomenViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WomenViewHolder holder, int position) {
        holder.ivMensItem.setImageResource(womensItemList.get(position).getImageUrl());
        holder.tvMenOutfitTitle.setText(womensItemList.get(position).getOutFitName());
    }

    @Override
    public int getItemCount() {
        return womensItemList.size();
    }

    public static class WomenViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivMensItem;
        private final TextView tvMenOutfitTitle;

        public WomenViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMensItem = itemView.findViewById(R.id.ivMensItem);
            tvMenOutfitTitle = itemView.findViewById(R.id.tvMenOutfitTitle);
        }
    }
}
