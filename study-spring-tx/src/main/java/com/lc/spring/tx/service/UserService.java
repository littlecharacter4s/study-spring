package com.lc.spring.tx.service;

import com.lc.spring.tx.entity.User;

public interface UserService {
    User getUserInfo(long userId);

    int addUser(User user);
}
