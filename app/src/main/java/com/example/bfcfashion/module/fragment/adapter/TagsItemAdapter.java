package com.example.bfcfashion.module.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfcfashion.R;
import com.example.bfcfashion.module.model.TagsItem;

import java.util.List;

public class TagsItemAdapter extends RecyclerView.Adapter<TagsItemAdapter.TagsViewHolder> {
    private final Context context;
    private final List<TagsItem> tagsItemList;

    public TagsItemAdapter(Context context, List<TagsItem> tagsItemList) {
        this.context = context;
        this.tagsItemList = tagsItemList;
    }

    @NonNull
    @Override
    public TagsItemAdapter.TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tags_item, parent, false);
        return new TagsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsItemAdapter.TagsViewHolder holder, int position) {
        holder.tagTitle.setText(tagsItemList.get(position).getTags());
    }

    @Override
    public int getItemCount() {
        return tagsItemList.size();
    }

    public static class TagsViewHolder extends RecyclerView.ViewHolder {
        private final TextView tagTitle;

        public TagsViewHolder(@NonNull View itemView) {
            super(itemView);

            tagTitle = itemView.findViewById(R.id.tagTitle);
        }
    }
}
