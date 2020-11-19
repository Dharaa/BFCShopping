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
import com.example.bfcfashion.module.model.MensItem;

import java.util.List;

public class MensAdapter extends RecyclerView.Adapter<MensAdapter.MensViewHolder> {
    private final Context context;
    private final List<MensItem> mensItemList;

    public MensAdapter(Context context, List<MensItem> mensItemList) {
        this.context = context;
        this.mensItemList = mensItemList;
    }

    @NonNull
    @Override
    public MensAdapter.MensViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mens_item, parent, false);
        return new MensViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MensAdapter.MensViewHolder holder, int position) {
        holder.ivMensItem.setImageResource(mensItemList.get(position).getImageUrl());
        holder.tvMenOutfitTitle.setText(mensItemList.get(position).getOutFitName());
    }

    @Override
    public int getItemCount() {
        return mensItemList.size();
    }

    public static class MensViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivMensItem;
        private final TextView tvMenOutfitTitle;

        public MensViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMensItem = itemView.findViewById(R.id.ivMensItem);
            tvMenOutfitTitle = itemView.findViewById(R.id.tvMenOutfitTitle);
        }
    }
}
