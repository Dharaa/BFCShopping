package com.example.bfcfashion.module.model.signup;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("login_id")
    private int loginId;

    @SerializedName("notification")
    private int notification;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("hash")
    private String hash;

    public int getLoginId() {
        return loginId;
    }

    public int getNotification() {
        return notification;
    }

    public String getMobile() {
        return mobile;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getHash() {
        return hash;
    }
}