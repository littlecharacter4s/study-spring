package com.lc.spring.tx.service;

import com.lc.spring.tx.entity.LabUser;

public interface UserService {
    LabUser getUserInfo(long userId);

    int addUser(LabUser user);
}
