package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.ColorsResponse.ColorsItem;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.KidViewHolder> {
    private Context context;
    private List<ColorsItem> ColorsItemList;

    public ColorAdapter(Context context, List<ColorsItem> ColorsItemList) {
        this.context = context;
        this.ColorsItemList = ColorsItemList;
    }

    @NonNull
    @Override
    public ColorAdapter.KidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.color_item, parent, false);
        return new KidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.KidViewHolder holder, int position) {
//        holder.ivColorsItem.setImageResource(ColorsItemList.get(position).get());
        holder.ivColorsItem.setBackgroundColor(Color.parseColor(ColorsItemList.get(position).getColorCode()));
        holder.tvColorTitle.setText(ColorsItemList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ColorsItemList.size();
    }

    public class KidViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivColorsItem;
        private TextView tvColorTitle;

        public KidViewHolder(@NonNull View itemView) {
            super(itemView);
            ivColorsItem = itemView.findViewById(R.id.ivColorItem);
            tvColorTitle = itemView.findViewById(R.id.tvColorTitle);
        }
    }
}
