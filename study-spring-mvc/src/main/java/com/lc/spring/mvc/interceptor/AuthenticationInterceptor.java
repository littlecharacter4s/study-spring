package com.lc.spring.mvc.interceptor;

import com.lc.spring.mvc.base.SpringFactory;
import com.lc.spring.mvc.service.UserService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserService userService = (UserService) SpringFactory.getBean("userService");
        if (userService.isAuthenticated(request)) {
            return true;
        }
        request.setAttribute("forwardUrl", request.getServletPath());
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}
