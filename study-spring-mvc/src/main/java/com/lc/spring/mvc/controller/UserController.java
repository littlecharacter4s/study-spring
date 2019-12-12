package com.lc.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.lc.spring.mvc.base.BaseContext;
import com.lc.spring.mvc.entity.User;
import com.lc.spring.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/main");
        User user =userService.getUserByName(BaseContext.instance().getUserName());
        mv.addObject("userInfo", JSON.toJSONString(user));
        return mv;
    }
}
