package com.lc.spring.tx.dao.impl;

import com.lc.spring.tx.dao.UserDao;
import com.lc.spring.tx.entity.LabUser;
import com.lc.spring.tx.mapper.LabUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private LabUserMapper labUserMapper;

    @Override
    public LabUser getUserInfo(long userId) {
        return labUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int addUser(LabUser user) {
        int result = labUserMapper.insert(user);
        this.exeAnother();
        return result;
    }

    private void exeAnother() {
        throw new RuntimeException();
    }
}
