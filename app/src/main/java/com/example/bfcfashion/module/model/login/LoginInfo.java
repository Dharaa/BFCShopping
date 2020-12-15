package com.example.bfcfashion.module.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginInfo {

    @SerializedName("login_id")
    private int loginId;

    @SerializedName("notification")
    private int notification;

    @SerializedName("user_type")
    private int userType;

    @SerializedName("id")
    private int id;

    @SerializedName("hash")
    private String hash;

    public int getLoginId() {
        return loginId;
    }

    public int getNotification() {
        return notification;
    }

    public int getUserType() {
        return userType;
    }

    public int getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }
}