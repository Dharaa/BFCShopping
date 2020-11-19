package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.WomenShopAdapter;
import com.example.bfcfashion.module.model.WomensItem;

import java.util.ArrayList;
import java.util.List;


public class MensShopFragment extends Fragment {
    private View view;
    private RecyclerView womenShopRecyclerView;
    private WomenShopAdapter womenShopAdapter;
    private List<WomensItem> womensItemList;


    public MensShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mens_shop, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        womenShopRecyclerView = view.findViewById(R.id.womenShopRecyclerView);
        womensItemList = new ArrayList<>();
        womensItemList.add(new WomensItem(R.drawable.jeans, "Jeans"));
        womensItemList.add(new WomensItem(R.drawable.clothes, "Clothes"));
        womensItemList.add(new WomensItem(R.drawable.shoe, "Shoes"));
        womensItemList.add(new WomensItem(R.drawable.text_with_two_line_dot, "Texts with Two\n" +
                "Line then dot ..."));
        setWomenShopRecyclerView(womensItemList);
    }

    private void setWomenShopRecyclerView(List<WomensItem> womensItems) {
        womenShopRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        womenShopAdapter = new WomenShopAdapter(getContext(), womensItems);
        womenShopRecyclerView.setAdapter(womenShopAdapter);
        womenShopAdapter.notifyDataSetChanged();
    }
}