package com.example.bfcfashion.module.model;

public class BagItem {
    private Integer imageUrl;
    private String itemTitle;
    private String color;
    private String size;
    private String price;

    public BagItem(Integer imageUrl, String itemTitle, String color, String size, String price) {
        this.imageUrl = imageUrl;
        this.itemTitle = itemTitle;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
