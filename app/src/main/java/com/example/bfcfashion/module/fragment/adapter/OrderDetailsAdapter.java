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
import com.example.bfcfashion.module.model.OrderDetails;

import java.util.List;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {
    private Context context;
    private List<OrderDetails> orderDetailsList;

    public OrderDetailsAdapter(Context context, List<OrderDetails> orderDetailsList) {
        this.context = context;
        this.orderDetailsList = orderDetailsList;
    }

    @NonNull
    @Override
    public OrderDetailsAdapter.OrderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_details_item, parent, false);
        return new OrderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsAdapter.OrderDetailsViewHolder holder, int position) {
        OrderDetails orderDetails = orderDetailsList.get(position);
        holder.ivOrderItem.setImageResource(orderDetails.getImageUrl());
        holder.tvItemName.setText(orderDetails.getItemName());
        holder.tvBrandName.setText(orderDetails.getItemType());
        holder.tvColorName.setText(orderDetails.getItemColor());
        holder.tvSize.setText(orderDetails.getItemSize());
        holder.tvUnit.setText(orderDetails.getItemUnit());
        holder.tvPrice.setText(orderDetails.getItemPrice());
    }

    @Override
    public int getItemCount() {
        return orderDetailsList.size();
    }

    public class OrderDetailsViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivOrderItem;
        private TextView tvItemName;
        private TextView tvBrandName;
        private TextView tvColorName;
        private TextView tvSize;
        private TextView tvUnit;
        private TextView tvPrice;

        public OrderDetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            ivOrderItem = itemView.findViewById(R.id.ivOrderItem);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvBrandName = itemView.findViewById(R.id.tvBrandName);
            tvColorName = itemView.findViewById(R.id.tvColorName);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvUnit = itemView.findViewById(R.id.tvUnit);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
