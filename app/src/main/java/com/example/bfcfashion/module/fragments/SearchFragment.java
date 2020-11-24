package com.example.bfcfashion.module.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.activity.FiltersActivity;
import com.example.bfcfashion.module.fragment.adapter.SearchItemAdapter;
import com.example.bfcfashion.module.fragment.adapter.SearchItemGridAdapter;
import com.example.bfcfashion.module.fragment.adapter.TagsItemAdapter;
import com.example.bfcfashion.module.model.SearchItem;
import com.example.bfcfashion.module.model.TagsItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements View.OnClickListener {
    int liked = 0;
    private View view;
    private RecyclerView tagsRecyclerView;
    private TagsItemAdapter tagsItemAdapter;
    private List<TagsItem> tagsItemList;
    private RecyclerView favRecyclerView;
    private SearchItemAdapter searchItemAdapter;
    private List<SearchItem> searchItemList;
    private SearchItemGridAdapter searchItemGridAdapter;
    private ImageView ivGridToLinear;
    private LinearLayout lhFilter;
    private LinearLayout lhSortBy;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tagsRecyclerView = view.findViewById(R.id.tagsRecyclerView);
        favRecyclerView = view.findViewById(R.id.favRecyclerView);
        ivGridToLinear = view.findViewById(R.id.ivGridToLinear);

        lhFilter = view.findViewById(R.id.lhFilter);
        lhSortBy = view.findViewById(R.id.lhSortBy);

        tagsItemList = new ArrayList<>();
        tagsItemList.add(new TagsItem("T-Shirts"));
        tagsItemList.add(new TagsItem("Crop tops"));
        tagsItemList.add(new TagsItem("Sleeveless"));
        tagsItemList.add(new TagsItem("Shirts"));
        setTagsRecyclerView(tagsItemList);

        searchItemList = new ArrayList<>();
        searchItemList.add(new SearchItem(R.drawable.fav_four, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_four, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_four, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_four, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_five, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_five, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_five, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_five, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_six, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_seven, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_seven, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_seven, "LIME", "Shirt", "32$"));
        searchItemList.add(new SearchItem(R.drawable.fav_seven, "LIME", "Shirt", "32$"));

        setFavRecyclerView(searchItemList);

        ivGridToLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liked == 1) {

                    setGridFavRecyclerView(searchItemList);
                    ivGridToLinear.setImageDrawable(getResources().getDrawable(R.drawable.ic_grid));
                    liked = 0;

                } else {

                    liked = 1;
                    setFavRecyclerView(searchItemList);
                    ivGridToLinear.setImageDrawable(getResources().getDrawable(R.drawable.ic_linear));

                }


            }
        });

        lhSortBy.setOnClickListener(this);
        lhFilter.setOnClickListener(this);
    }

    private void setTagsRecyclerView(List<TagsItem> tagsItems) {
        tagsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        tagsItemAdapter = new TagsItemAdapter(getContext(), tagsItems);
        tagsRecyclerView.setAdapter(tagsItemAdapter);
        tagsItemAdapter.notifyDataSetChanged();
    }

    private void setFavRecyclerView(List<SearchItem> searchItems) {
        favRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        searchItemAdapter = new SearchItemAdapter(getContext(), searchItems);
        favRecyclerView.setAdapter(searchItemAdapter);
        searchItemAdapter.notifyDataSetChanged();
    }

    private void setGridFavRecyclerView(List<SearchItem> searchItems) {
        favRecyclerView = view.findViewById(R.id.favRecyclerView);
        favRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        searchItemGridAdapter = new SearchItemGridAdapter(getContext(), searchItems);
        favRecyclerView.setAdapter(searchItemGridAdapter);
        searchItemGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v == lhFilter) {
            openFilterActivity();
        }
        if (v == lhSortBy) {
            openBottomSheet();
        }
    }

    private void openBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getContext(), R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getContext())
                .inflate(
                        R.layout.layout_filter_bottom_sheet,
                        (LinearLayout) view.findViewById(R.id.bottomSheetContainer)
                );
        bottomSheetView.findViewById(R.id.etOldPassword);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void openFilterActivity() {
        Intent intent = new Intent(getActivity(), FiltersActivity.class);
        getContext().startActivity(intent);
    }

    //commenting for push
}