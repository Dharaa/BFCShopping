package com.example.bfcfashion.module.model.categoryResponse;

import com.google.gson.annotations.SerializedName;

public class CatagoriesItem {

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("sku_url")
    private String skuUrl;

    @SerializedName("key")
    private int key;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSkuUrl() {
        return skuUrl;
    }

    public int getKey() {
        return key;
    }
}