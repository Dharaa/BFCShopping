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
import com.example.bfcfashion.module.model.BagItem;

import java.util.List;

public class BagItemAdapter extends RecyclerView.Adapter<BagItemAdapter.BagItemViewHolder> {
    private Context context;
    private List<BagItem> bagItemList;

    public BagItemAdapter(Context context, List<BagItem> bagItemList) {
        this.context = context;
        this.bagItemList = bagItemList;
    }

    @NonNull
    @Override
    public BagItemAdapter.BagItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bag_list_item, parent, false);
        return new BagItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BagItemAdapter.BagItemViewHolder holder, int position) {
        BagItem bagItem = bagItemList.get(position);
        holder.ivBagItem.setImageResource(bagItem.getImageUrl());
        holder.tvBagItem.setText(bagItem.getItemTitle());
        holder.tvColor.setText(bagItem.getColor());
        holder.tvSize.setText(bagItem.getSize());
        holder.tvPrice.setText(bagItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return bagItemList.size();
    }

    public class BagItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivBagItem;
        private TextView tvBagItem;
        private TextView tvColor;
        private TextView tvSize;
        private TextView tvPrice;

        public BagItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivBagItem = itemView.findViewById(R.id.ivBagItem);
            tvBagItem = itemView.findViewById(R.id.tvBagItem);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
