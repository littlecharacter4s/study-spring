package com.lc.spring.tx.service.impl;

import com.lc.spring.tx.dao.DrawDao;
import com.lc.spring.tx.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("drawService")
public class DrawServiceImpl implements DrawService {
    @Autowired
    private DrawDao drawDao;


    @Override
    @Transactional(rollbackFor=Exception.class)
    public String getDraw(long drawId) {
        return drawDao.getDraw(drawId);
    }
}
