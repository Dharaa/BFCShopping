package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragments.OrderDetailsFragment;
import com.example.bfcfashion.module.model.DeliveredItem;

import java.util.List;

public class DeliveredAdapter extends RecyclerView.Adapter<DeliveredAdapter.DeliveredViewHolder> {
    private Context context;
    private List<DeliveredItem> deliveredItemList;


    public DeliveredAdapter(Context context, List<DeliveredItem> deliveredItemList) {
        this.context = context;
        this.deliveredItemList = deliveredItemList;
    }

    @NonNull
    @Override
    public DeliveredAdapter.DeliveredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_order_item, parent, false);
        return new DeliveredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveredAdapter.DeliveredViewHolder holder, int position) {
        DeliveredItem deliveredItem = deliveredItemList.get(position);
        holder.tvOrderNo.setText(deliveredItem.getOrderNo());
        holder.tvDate.setText(deliveredItem.getDate());
        holder.tvTrackingNo.setText(deliveredItem.getTrackingNo());
        holder.tvQuantity.setText(deliveredItem.getQuantity());
        holder.tvTotalAmount.setText(deliveredItem.getTotalAmount());
        holder.tvStatus.setText(deliveredItem.getStatus());

        holder.tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, orderDetailsFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return deliveredItemList.size();
    }

    public class DeliveredViewHolder extends RecyclerView.ViewHolder {
        private TextView tvOrderNo;
        private TextView tvDate;
        private TextView tvTrackingNo;
        private TextView tvQuantity;
        private TextView tvTotalAmount;
        private TextView tvStatus;
        private TextView tvDetails;

        public DeliveredViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderNo = itemView.findViewById(R.id.tvOrderNo);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTrackingNo = itemView.findViewById(R.id.tvTrackingNo);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvTotalAmount = itemView.findViewById(R.id.tvTotalAmount);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvDetails = itemView.findViewById(R.id.tvDetails);
        }
    }
}
