package com.learn.common;

import lombok.Data;

/**
 * @program: leetCode
 * @description: 用户
 * @author: 空见
 * @create: 2021-03-01 23:15
 */


public class User {
    private Long id;
    private String userName;
    private String like;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
