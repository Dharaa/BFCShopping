package com.example.bfcfashion.module.model;

public class FavListItem {
    private Integer imageUrl;
    private String shirtType;
    private String type;
    private String color;
    private String size;
    private String price;

    public FavListItem(Integer imageUrl, String shirtType, String type, String color, String size, String price) {
        this.imageUrl = imageUrl;
        this.shirtType = shirtType;
        this.type = type;
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

    public String getShirtType() {
        return shirtType;
    }

    public void setShirtType(String shirtType) {
        this.shirtType = shirtType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
