package com.example.bfcfashion.module.model;

public class OrderDetails {
    private Integer imageUrl;
    private String itemName;
    private String itemType;
    private String itemColor;
    private String itemSize;
    private String itemPrice;
    private String itemUnit;

    public OrderDetails(Integer imageUrl, String itemName, String itemType, String itemColor, String itemSize, String itemPrice, String itemUnit) {
        this.imageUrl = imageUrl;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemColor = itemColor;
        this.itemSize = itemSize;
        this.itemPrice = itemPrice;
        this.itemUnit = itemUnit;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }
}
