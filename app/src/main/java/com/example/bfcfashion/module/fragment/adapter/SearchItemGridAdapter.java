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
import com.example.bfcfashion.module.model.SearchItem;

import java.util.List;

public class SearchItemGridAdapter extends RecyclerView.Adapter<SearchItemGridAdapter.SearchViewHolder> {
    private Context context;
    private List<SearchItem> searchItemList;

    public SearchItemGridAdapter(Context context, List<SearchItem> searchItemList) {
        this.context = context;
        this.searchItemList = searchItemList;
    }

    @NonNull
    @Override
    public SearchItemGridAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item_grid, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemGridAdapter.SearchViewHolder holder, int position) {
        SearchItem searchItem = searchItemList.get(position);
        holder.ivOrderItem.setImageResource(searchItem.getImageUrl());
        holder.tvItemName.setText(searchItem.getName());
        holder.tvBrandName.setText(searchItem.getBrandName());
        holder.tvPrice.setText(searchItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return searchItemList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivOrderItem;
        private TextView tvItemName;
        private TextView tvBrandName;
        private TextView tvPrice;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            ivOrderItem = itemView.findViewById(R.id.ivOrderItem);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvBrandName = itemView.findViewById(R.id.tvBrandName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
