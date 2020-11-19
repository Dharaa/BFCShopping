package com.example.bfcfashion.module.model;

public class MensItem {
    private Integer imageUrl;
    private String outFitName;

    public MensItem(Integer imageUrl, String outFitName) {
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

