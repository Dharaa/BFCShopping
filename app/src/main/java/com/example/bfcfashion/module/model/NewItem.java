package com.example.bfcfashion.module.model;

public class NewItem {
    private Integer imageUrl;
    private String tvProviderName;
    private String tvTrendingDressName;
    private String tvTotalPrice;

    public NewItem(Integer imageUrl, String tvProviderName, String tvTrendingDressName, String tvTotalPrice) {
        this.imageUrl = imageUrl;
        this.tvProviderName = tvProviderName;
        this.tvTrendingDressName = tvTrendingDressName;
        this.tvTotalPrice = tvTotalPrice;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTvProviderName() {
        return tvProviderName;
    }

    public void setTvProviderName(String tvProviderName) {
        this.tvProviderName = tvProviderName;
    }

    public String getTvTrendingDressName() {
        return tvTrendingDressName;
    }

    public void setTvTrendingDressName(String tvTrendingDressName) {
        this.tvTrendingDressName = tvTrendingDressName;
    }

    public String getTvTotalPrice() {
        return tvTotalPrice;
    }

    public void setTvTotalPrice(String tvTotalPrice) {
        this.tvTotalPrice = tvTotalPrice;
    }
}
