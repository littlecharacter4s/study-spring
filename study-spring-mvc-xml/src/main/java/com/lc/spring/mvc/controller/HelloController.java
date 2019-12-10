package com.lc.spring.mvc.controller;


import com.lc.spring.mvc.service.HelloService;
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
        String hello = helloService.hello();
        mv.addObject("content", hello);
        return mv;
	}

    @RequestMapping("/springmvc/hello")
    public ModelAndView helloSpringmvc() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        String hello = helloService.hello();
        mv.addObject("content", hello + " SpringMVC");
        return mv;
    }

    @RequestMapping("/springmvc/test/hello")
    public ModelAndView helloSpringmvcTest() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        String hello = helloService.hello();
        mv.addObject("content", hello + " SpringMVCTest");
        return mv;
    }
}
