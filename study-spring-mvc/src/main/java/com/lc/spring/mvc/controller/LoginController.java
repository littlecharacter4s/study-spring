package com.lc.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.lc.spring.mvc.base.BaseContext;
import com.lc.spring.mvc.entity.User;
import com.lc.spring.mvc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Objects;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("loginUser") == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                Cookie cookie = Arrays.stream(cookies).filter(cke -> Objects.equals("study-spring-mvc", cke.getName())).findFirst().orElse(null);
                if (cookie != null) {
                    User loginUser = JSON.parseObject(new String(Base64.getDecoder().decode(cookie.getValue())), User.class);
                    session.setAttribute("loginUser", loginUser);
                }
            }
        }
        return "home";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberme");
        String forwardUrl = StringUtils.isEmpty(request.getParameter("forwardUrl")) ? "/" : request.getParameter("forwardUrl");
        System.out.println(forwardUrl);
        if (userService.isAuthenticated(request)) {
            mv.setViewName("redirect:" + forwardUrl);
            return mv;
        }
        User user = userService.getUserByName(username);
        if ((user != null && user.getPasswd().equals(password))) {
            session.setAttribute("loginUser", user);
            BaseContext.instance().setUser(user);
            if (Objects.equals(rememberMe, "remember-me")) {
                String value = Base64.getEncoder().encodeToString(JSON.toJSONString(user).getBytes());
                Cookie cookie = new Cookie("study-spring-mvc", value);
                cookie.setPath("/");
                cookie.setMaxAge(2592000);
                // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
                response.addCookie(cookie);
            }
            //防止表单重复提交，可以重定向到主页
            mv.setViewName("redirect:" + forwardUrl);
            return mv;
        }
        if (StringUtils.isNotEmpty(username) || StringUtils.isNotEmpty(password)) {
            mv.addObject("msg", "用户名或密码错误");
        }
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login");
        // 清除session
        Enumeration<String> em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        request.getSession().invalidate();
        // 清除cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return mv;
        }
        Cookie cookie = Arrays.stream(cookies).filter(cke -> Objects.equals("study-spring-mvc", cke.getName())).findFirst().orElse(null);
        if (cookie == null) {
            return mv;
        }
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return mv;
    }
}
