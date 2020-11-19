package com.example.bfcfashion.module.model;

public class WomensItem {
    private Integer imageUrl;
    private String outFitName;

    public WomensItem(Integer imageUrl, String outFitName) {
        this.imageUrl = imageUrl;
        this.outFitName = outFitName;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOutFitName() {
        return outFitName;
    }

    public void setOutFitName(String outFitName) {
        this.outFitName = outFitName;
    }
}

