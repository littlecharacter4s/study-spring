package com.lc.spring.mvc.base;

import com.lc.spring.mvc.entity.User;

public final class BaseContext {
    private User user;

    private BaseContext() {}

    private static class BaseContextInner {
        private static final BaseContext baseContext = new BaseContext();

        private BaseContextInner() {}
    }

    public static BaseContext instance() {
        return BaseContextInner.baseContext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return user.getName();
    }
}
