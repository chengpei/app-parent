package com.whpe.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/2/20.
 */
public class Person {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
