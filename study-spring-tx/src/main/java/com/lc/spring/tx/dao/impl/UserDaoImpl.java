package com.lc.spring.tx.dao.impl;

import com.lc.spring.tx.dao.UserDao;
import com.lc.spring.tx.entity.User;
import com.lc.spring.tx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int addUser(User user) {
        int result = userMapper.insert(user);
        this.exeAnother();
        return result;
    }

    private void exeAnother() {
        throw new RuntimeException();
    }
}
