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
import com.example.bfcfashion.module.model.KidItem;

import java.util.List;

public class KidAdapter extends RecyclerView.Adapter<KidAdapter.KidViewHolder> {
    private Context context;
    private List<KidItem> kidItemList;

    public KidAdapter(Context context, List<KidItem> kidItemList) {
        this.context = context;
        this.kidItemList = kidItemList;
    }

    @NonNull
    @Override
    public KidAdapter.KidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kids_item, parent, false);
        return new KidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KidAdapter.KidViewHolder holder, int position) {
        holder.ivKidItem.setImageResource(kidItemList.get(position).getImageUrl());
        holder.tvKidOutfitTitle.setText(kidItemList.get(position).getOutFitName());
    }

    @Override
    public int getItemCount() {
        return kidItemList.size();
    }

    public class KidViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivKidItem;
        private TextView tvKidOutfitTitle;

        public KidViewHolder(@NonNull View itemView) {
            super(itemView);
            ivKidItem = itemView.findViewById(R.id.ivKidItem);
            tvKidOutfitTitle = itemView.findViewById(R.id.tvKidOutfitTitle);
        }
    }
}
