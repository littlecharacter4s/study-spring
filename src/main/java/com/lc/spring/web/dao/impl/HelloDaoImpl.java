package com.lc.spring.web.dao.impl;

import com.lc.spring.web.dao.HelloDao;
import com.lc.spring.zzz.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class HelloDaoImpl implements HelloDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User hello() {
        return jdbcTemplate.queryForObject("select * from tb_user where id = ?", new Object[]{1}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday"));
            user.setCreateTime(rs.getDate("create_time"));
            user.setUpdateTime(rs.getDate("update_time"));
            user.setVersion(rs.getInt("version"));
            return user;
        });
    }
}
