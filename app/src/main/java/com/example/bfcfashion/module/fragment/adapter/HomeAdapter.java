package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.categoryResponse.CatagoriesItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context context;
    private List<CatagoriesItem> categoryItemList;

    public HomeAdapter(Context context, List<CatagoriesItem> categoryItemList) {
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
        CatagoriesItem item = categoryItemList.get(position);
//        holder.ivCategory.setImageResource(item.getImage());
        Glide.with(context).load(item.getSkuUrl())
                .placeholder(R.drawable.placeholder)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivCategory);
        holder.tvCategoryName.setText(item.getTitle());
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
