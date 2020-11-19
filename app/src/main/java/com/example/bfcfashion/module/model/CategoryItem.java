package com.example.bfcfashion.module.model;

public class CategoryItem {
    private int imageUrl;
    private String title;

    public CategoryItem(int imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
