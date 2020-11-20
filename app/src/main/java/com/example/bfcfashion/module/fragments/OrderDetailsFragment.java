package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.OrderDetailsAdapter;
import com.example.bfcfashion.module.model.OrderDetails;

import java.util.ArrayList;
import java.util.List;


public class OrderDetailsFragment extends Fragment {

    private View view;
    private RecyclerView orderDetailsRecyclerView;
    private List<OrderDetails> orderDetailsList;
    private OrderDetailsAdapter orderDetailsAdapter;

    public OrderDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_details, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        orderDetailsRecyclerView = view.findViewById(R.id.orderDetailsRecyclerView);

        orderDetailsList = new ArrayList<>();
        orderDetailsList.add(new OrderDetails(R.drawable.bag_item_one, "Pullover", "Mango", "Gray", "L", "51$", "1"));
        orderDetailsList.add(new OrderDetails(R.drawable.bag_item_one, "Pullover", "Mango", "Gray", "L", "51$", "1"));
        orderDetailsList.add(new OrderDetails(R.drawable.bag_item_one, "Pullover", "Mango", "Gray", "L", "51$", "1"));
        orderDetailsList.add(new OrderDetails(R.drawable.bag_item_one, "Pullover", "Mango", "Gray", "L", "51$", "1"));

        setOrderDetailsRecyclerView(orderDetailsList);
    }

    private void setOrderDetailsRecyclerView(List<OrderDetails> orderDetails) {
        orderDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        orderDetailsAdapter = new OrderDetailsAdapter(getContext(), orderDetails);
        orderDetailsRecyclerView.setAdapter(orderDetailsAdapter);
        orderDetailsAdapter.notifyDataSetChanged();
    }
}