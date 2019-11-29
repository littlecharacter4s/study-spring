package com.lc.spring.aop.pojo;

public class Result {
    String state;
    Object data;

    public Result(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return "success".equals(state);
    }
}
