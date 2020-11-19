package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.BagItemAdapter;
import com.example.bfcfashion.module.model.BagItem;

import java.util.ArrayList;
import java.util.List;


public class BagFragment extends Fragment {
    private View view;
    private RecyclerView bagRecyclerView;
    private BagItemAdapter bagItemAdapter;
    private List<BagItem> bagItemList;

    public BagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bag, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        bagRecyclerView = view.findViewById(R.id.bagRecyclerView);

        bagItemList = new ArrayList<>();
        bagItemList.add(new BagItem(R.drawable.bag_item_one, "Pullover", "Black", "L", "51$"));
        bagItemList.add(new BagItem(R.drawable.bag_item_two, "T-Shirt", "Gray", "L", "30$"));
        bagItemList.add(new BagItem(R.drawable.bag_item_three, "Pullover", "Sport Dress", "M", "43$"));
        setBagRecyclerView(bagItemList);
    }

    private void setBagRecyclerView(List<BagItem> bagItems) {
        bagRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        bagItemAdapter = new BagItemAdapter(getContext(), bagItems);
        bagRecyclerView.setAdapter(bagItemAdapter);
        bagItemAdapter.notifyDataSetChanged();
    }
}