package com.lc.spring.mvc.service.impl;

import com.lc.spring.mvc.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
	@Override
	public String hello() {
		return "Hello World";
	}
}
