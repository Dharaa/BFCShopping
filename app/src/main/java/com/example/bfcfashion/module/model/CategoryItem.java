package com.example.bfcfashion.module.model;

import com.google.gson.annotations.SerializedName;

public class CategoryItem {
    @SerializedName("image")
    private int imageUrl;
    @SerializedName("title")
    private String title;
    @SerializedName("key")
    private int key;
    @SerializedName("sku_url")
    private String skuUrl;

    public CategoryItem(int imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getSkuUrl() {
        return skuUrl;
    }

    public void setSkuUrl(String skuUrl) {
        this.skuUrl = skuUrl;
    }
}
