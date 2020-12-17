package com.example.bfcfashion.module.model.ColorsResponse;

import com.google.gson.annotations.SerializedName;

public class ColorsItem {

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("color_code")
    private String colorCode;

    @SerializedName("key")
    private int key;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getColorCode() {
        return colorCode;
    }

    public int getKey() {
        return key;
    }
}