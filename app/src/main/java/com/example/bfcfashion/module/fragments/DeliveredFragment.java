package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.DeliveredAdapter;
import com.example.bfcfashion.module.model.DeliveredItem;

import java.util.ArrayList;
import java.util.List;


public class DeliveredFragment extends Fragment {
    private View view;
    private List<DeliveredItem> deliveredItemList;
    private DeliveredAdapter deliveredAdapter;
    private RecyclerView deliveredRecyclerView;

    public DeliveredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delivered, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        deliveredRecyclerView = view.findViewById(R.id.deliveredRecyclerView);

        deliveredItemList = new ArrayList<>();
        deliveredItemList.add(new DeliveredItem("Order №1947034", "05-12-2019", "IW3475453455", "3", "112$", "Delivered"));
        deliveredItemList.add(new DeliveredItem("Order №1947034", "05-12-2019", "IW3475453455", "3", "112$", "Delivered"));
        deliveredItemList.add(new DeliveredItem("Order №1947034", "05-12-2019", "IW3475453455", "3", "112$", "Delivered"));

        setDeliveredRecyclerView(deliveredItemList);
    }

    private void setDeliveredRecyclerView(List<DeliveredItem> deliveredItems) {
        deliveredRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        deliveredAdapter = new DeliveredAdapter(getContext(), deliveredItems);
        deliveredRecyclerView.setAdapter(deliveredAdapter);
        deliveredAdapter.notifyDataSetChanged();
    }
}