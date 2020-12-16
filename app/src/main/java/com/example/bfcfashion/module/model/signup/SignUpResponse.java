package com.example.bfcfashion.module.model.signup;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    @SerializedName("user_info")
    private UserInfo userInfo;

    @SerializedName("error")
    private boolean error;

    @SerializedName("msg")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public boolean isError() {
        return error;
    }
}