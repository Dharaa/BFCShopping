package com.example.bfcfashion.module.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.activity.CheckOutActivity;
import com.example.bfcfashion.module.fragment.adapter.BagItemAdapter;
import com.example.bfcfashion.module.model.BagItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class BagFragment extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView bagRecyclerView;
    private BagItemAdapter bagItemAdapter;
    private List<BagItem> bagItemList;
    private LinearLayout lhPromoCode;
    private TextView tvCheckout;

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
        lhPromoCode = view.findViewById(R.id.lhPromoCode);
        tvCheckout = view.findViewById(R.id.tvCheckout);

        lhPromoCode.setOnClickListener(this);
        tvCheckout.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == lhPromoCode) {
            openPromoDialog();
        }
        if (v == tvCheckout) {
            goToCheckOut();
        }
    }

    private void goToCheckOut() {
        Intent intent = new Intent(getActivity(), CheckOutActivity.class);
        getContext().startActivity(intent);
    }

    private void openPromoDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getContext(), R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getContext())
                .inflate(
                        R.layout.layout_promocode_bottom_sheet,
                        (LinearLayout) view.findViewById(R.id.bottomSheetContainerPromoCode)
                );
        bottomSheetView.findViewById(R.id.etOldPassword);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}