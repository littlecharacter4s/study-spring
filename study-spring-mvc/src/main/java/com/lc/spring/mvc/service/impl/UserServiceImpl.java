package com.lc.spring.mvc.service.impl;

import com.alibaba.fastjson.JSON;
import com.lc.spring.mvc.base.BaseContext;
import com.lc.spring.mvc.entity.User;
import com.lc.spring.mvc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByName(String username) {
        User user = new User();
        user.setId(1234567890L);
        user.setName("littlecharacter");
        user.setPasswd("123456");
        user.setNickname("lc");
        user.setPhone("18719877639");
        user.setEmail("123456789@qq.com");
        user.setAddress("北京市朝阳区望京");
        user.setRealName("gujx");
        user.setIdNumber("202020199009243235");
        user.setSex(0);
        user.setRemark("风一样的男子");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setVersion(0);
        if (StringUtils.isEmpty(username) || !Objects.equals(user.getName(), username)) {
            return null;
        }
        return user;
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object sessionUser = session.getAttribute("loginUser");
        User loginUser;
        if (sessionUser == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                return false;
            }
            Cookie cookie = Arrays.stream(cookies).filter(cke -> Objects.equals("study-spring-mvc", cke.getName())).findFirst().orElse(null);
            if (cookie == null) {
                return false;
            }
            loginUser = JSON.parseObject(Base64.getDecoder().decode(cookie.getValue()), User.class);
        } else {
            loginUser = (User) sessionUser;
        }
        User user = this.getUserByName(loginUser.getName());
        if (user != null && Objects.equals(loginUser.getPasswd(), user.getPasswd())) {
            BaseContext.instance().setUser(user);
            return true;
        }
        return false;
    }
}
