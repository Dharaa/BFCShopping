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
import com.example.bfcfashion.module.model.CategoryItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList;

    public HomeAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_story_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {
        holder.ivCategory.setImageResource(categoryItemList.get(position).getImageUrl());
        holder.tvCategoryName.setText(categoryItemList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCategory;
        private TextView tvCategoryName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
            ivCategory = itemView.findViewById(R.id.ivCategory);
        }
    }
}
