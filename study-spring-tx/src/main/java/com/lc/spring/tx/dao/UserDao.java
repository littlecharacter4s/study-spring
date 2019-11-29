package com.lc.spring.tx.dao;

import com.lc.spring.tx.entity.User;

public interface UserDao {
    User getUserInfo(long userId);

    int addUser(User user);
}
