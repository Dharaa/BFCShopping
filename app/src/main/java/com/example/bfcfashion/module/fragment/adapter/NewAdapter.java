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
import com.example.bfcfashion.module.model.NewItem;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {
    private Context context;
    private List<NewItem> newItemList;

    public NewAdapter(Context context, List<NewItem> newItemList) {
        this.context = context;
        this.newItemList = newItemList;
    }

    @NonNull
    @Override
    public NewAdapter.NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_item, parent, false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.NewViewHolder holder, int position) {
        holder.ivNew.setImageResource(newItemList.get(position).getImageUrl());
        holder.tvProviderName.setText(newItemList.get(position).getTvProviderName());
        holder.tvTrendingDressName.setText(newItemList.get(position).getTvTrendingDressName());
        holder.tvTotalPrice.setText(newItemList.get(position).getTvTotalPrice());
    }

    @Override
    public int getItemCount() {
        return newItemList.size();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivNew;
        private TextView tvProviderName;
        private TextView tvTrendingDressName;
        private TextView tvTotalPrice;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);

            ivNew = itemView.findViewById(R.id.ivNew);
            tvProviderName = itemView.findViewById(R.id.tvProviderName);
            tvTrendingDressName = itemView.findViewById(R.id.tvTrendingDressName);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
        }
    }
}
