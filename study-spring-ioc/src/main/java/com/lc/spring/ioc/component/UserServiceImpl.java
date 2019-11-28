package com.lc.spring.ioc.component;

public class UserServiceImpl {
    public String getUserName(Long userId) {
        return "Tom-" + userId;
    }
}
