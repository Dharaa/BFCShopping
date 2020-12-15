package com.example.bfcfashion.module.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("login_info")
    private LoginInfo loginInfo;

    @SerializedName("error")
    private boolean error;

    public String getMsg() {
        return msg;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public boolean isError() {
        return error;
    }
}