package com.cat.model.bean;

import lombok.Data;

/**
 * Created by wangxiaoqiang on 2017/7/6.
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String realname;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
