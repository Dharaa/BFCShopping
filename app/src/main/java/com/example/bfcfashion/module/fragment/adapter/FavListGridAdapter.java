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
import com.example.bfcfashion.module.model.FavListItem;

import java.util.List;

public class FavListGridAdapter extends RecyclerView.Adapter<FavListGridAdapter.FavListViewHolder> {
    private Context context;
    private List<FavListItem> favListItemList;

    public FavListGridAdapter(Context context, List<FavListItem> favListItemList) {
        this.context = context;
        this.favListItemList = favListItemList;
    }

    @NonNull
    @Override
    public FavListGridAdapter.FavListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fav_list_item_grid, parent, false);
        return new FavListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavListGridAdapter.FavListViewHolder holder, int position) {
        FavListItem favListItem = favListItemList.get(position);
        holder.ivItem.setImageResource(favListItem.getImageUrl());
        holder.tvShirtType.setText(favListItem.getShirtType());
        holder.tvType.setText(favListItem.getType());
        holder.tvColor.setText(favListItem.getColor());
        holder.tvSize.setText(favListItem.getSize());
        holder.tvPrice.setText(favListItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return favListItemList.size();
    }

    public class FavListViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivItem;
        private TextView tvShirtType;
        private TextView tvType;
        private TextView tvColor;
        private TextView tvSize;
        private TextView tvPrice;

        public FavListViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItem = itemView.findViewById(R.id.ivItem);
            tvShirtType = itemView.findViewById(R.id.tvShirtType);
            tvType = itemView.findViewById(R.id.tvType);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
