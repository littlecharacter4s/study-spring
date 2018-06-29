package com.lc.spring.web.service.impl;

import com.lc.spring.web.dao.HelloDao;
import com.lc.spring.web.entity.User;
import com.lc.spring.web.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements HelloService {
	@Resource
	private HelloDao helloDao;

	@Override
	public User hello() {
		return helloDao.hello();
	}
}
