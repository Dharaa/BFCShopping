package com.example.bfcfashion.module.model.ColorsResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetColorsResponse {

    @SerializedName("error")
    private boolean error;

    @SerializedName("colors")
    private List<ColorsItem> color;

    @SerializedName("msg")
    private String msg;

    public boolean isError() {
        return error;
    }

    public List<ColorsItem> getColor() {
        return color;
    }

    public String getMsg() {
        return msg;
    }
}