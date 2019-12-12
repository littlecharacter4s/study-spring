package com.lc.spring.mvc.service;

import com.lc.spring.mvc.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User getUserByName(String username);

    boolean isAuthenticated(HttpServletRequest request);
}
