package com.lc.spring.tx.dao.impl;

import com.lc.spring.tx.dao.DrawDao;
import org.springframework.stereotype.Repository;

@Repository
public class DrawDaoImpl implements DrawDao {
    @Override
    public String getDraw(long drawId) {
        return "haha";
    }
}
