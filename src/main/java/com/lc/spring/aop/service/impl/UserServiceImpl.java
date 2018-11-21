package com.lc.spring.aop.service.impl;

import com.lc.spring.aop.service.UserService;
import com.lc.spring.zzz.entity.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(User user) {
        System.out.println("addUser:添加用户.");
        return 1;
    }
}
