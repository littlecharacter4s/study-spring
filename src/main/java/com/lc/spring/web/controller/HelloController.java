package com.lc.spring.web.controller;

import com.lc.spring.web.entity.User;
import com.lc.spring.web.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HelloController {
	@Resource
	private HelloService helloService;

	@RequestMapping("/hello")
	public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        User user = helloService.hello();
        mv.addObject("user", user);
        return mv;
	}
}
