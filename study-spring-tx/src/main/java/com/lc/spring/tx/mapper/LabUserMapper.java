package com.lc.spring.tx.mapper;


import com.lc.spring.tx.entity.LabUser;

public interface LabUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LabUser record);

    int insertSelective(LabUser record);

    LabUser selectByPrimaryKey(Long id);

    LabUser selectByPhone(String phone);

    LabUser selectByUsername(String username);

    int updateByPrimaryKeySelective(LabUser record);

    int updateByPrimaryKey(LabUser record);

}