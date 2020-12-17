package com.example.bfcfashion.module.model.GetBrand;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBrandsResponse {

    @SerializedName("error")
    private boolean error;

    @SerializedName("brand")
    private List<BrandItem> brand;

    @SerializedName("msg")
    private String msg;

    public boolean isError() {
        return error;
    }

    public List<BrandItem> getBrand() {
        return brand;
    }

    public String getMsg() {
        return msg;
    }
}