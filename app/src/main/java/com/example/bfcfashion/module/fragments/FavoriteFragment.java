package com.example.bfcfashion.module.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.fragment.adapter.FavListAdapter;
import com.example.bfcfashion.module.fragment.adapter.TagsItemAdapter;
import com.example.bfcfashion.module.model.FavListItem;
import com.example.bfcfashion.module.model.TagsItem;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {
    private View view;
    private RecyclerView tagsRecyclerView;
    private TagsItemAdapter tagsItemAdapter;
    private List<TagsItem> tagsItemList;
    private RecyclerView favRecyclerView;
    private FavListAdapter favListAdapter;
    private List<FavListItem> favListItemList;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        initViews();
        return view;
    }

    private void initViews() {

        tagsRecyclerView = view.findViewById(R.id.tagsRecyclerView);
        favRecyclerView = view.findViewById(R.id.favRecyclerView);

        tagsItemList = new ArrayList<>();
        tagsItemList.add(new TagsItem("Summer"));
        tagsItemList.add(new TagsItem("T-Shirts"));
        tagsItemList.add(new TagsItem("Shirts"));
        tagsItemList.add(new TagsItem("Shirts"));
        setTagsRecyclerView(tagsItemList);

        favListItemList = new ArrayList<>();
        favListItemList.add(new FavListItem(R.drawable.fav_one, "LIME", "Shirt", "Blue", "L", "32$"));
        favListItemList.add(new FavListItem(R.drawable.fav_two, "Mango", "Longsleeve Violeta", "Orange", "S", "46$"));
        favListItemList.add(new FavListItem(R.drawable.fav_three, "Olivier", "Shirt", "Gray", "L", "52$"));
        favListItemList.add(new FavListItem(R.drawable.fav_four, "&Berries", "T-Shirt", "Blue", "S", "32$"));
        favListItemList.add(new FavListItem(R.drawable.fav_five, "&Berries", "T-Shirt", "Blue", "S", "32$"));
        favListItemList.add(new FavListItem(R.drawable.fav_six, "&Berries", "T-Shirt", "Blue", "S", "32$"));
        favListItemList.add(new FavListItem(R.drawable.fav_seven, "&Berries", "T-Shirt", "Blue", "S", "32$"));
        setFavRecyclerView(favListItemList);
    }

    private void setTagsRecyclerView(List<TagsItem> tagsItems) {

        tagsItemAdapter = new TagsItemAdapter(getContext(), tagsItems);
        tagsRecyclerView.setAdapter(tagsItemAdapter);
        tagsItemAdapter.notifyDataSetChanged();
    }

    private void setFavRecyclerView(List<FavListItem> favListItems) {
        favRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        favListAdapter = new FavListAdapter(getContext(), favListItems);
        favRecyclerView.setAdapter(favListAdapter);
        favListAdapter.notifyDataSetChanged();
    }
}