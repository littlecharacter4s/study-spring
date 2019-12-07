package com.lc.spring.mvc.service.impl;

import com.lc.spring.mvc.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("helloService")
public class HelloServiceImpl implements HelloService, ApplicationContextAware {
	ApplicationContext applicationContext;

	@Override
	public String hello() {
		String[] definitionBeans = applicationContext.getBeanDefinitionNames();
		Arrays.stream(definitionBeans).forEach(System.out::println);
		return "Hello World";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
