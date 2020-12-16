package com.example.bfcfashion.module.model.categoryResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCategoryResponse {

    @SerializedName("catagories")
    private List<CatagoriesItem> catagories;

    @SerializedName("error")
    private boolean error;
    @SerializedName("msg")
    private String msg;

    public List<CatagoriesItem> getCatagories() {
        return catagories;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isError() {
        return error;
    }
}