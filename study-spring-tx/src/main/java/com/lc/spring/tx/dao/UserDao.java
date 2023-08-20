package com.lc.spring.tx.dao;

import com.lc.spring.tx.entity.LabUser;

public interface UserDao {
    LabUser getUserInfo(long userId);

    int addUser(LabUser user);
}
