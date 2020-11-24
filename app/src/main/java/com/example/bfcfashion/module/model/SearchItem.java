package com.example.bfcfashion.module.model;

public class SearchItem {
    private Integer imageUrl;
    private String name;
    private String brandName;
    private String price;

    public SearchItem(Integer imageUrl, String name, String brandName, String price) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
    }


    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
