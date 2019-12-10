package com.lc.spring.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialInterceptor implements HandlerInterceptor {

    /**
     * 目标方法运行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("SpecialInterceptor：preHandle..." + request.getRequestURI());
		return true;
	}

    /**
     * 调用目标方法之后, 渲染视图之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
        System.out.println("SpecialInterceptor：postHandle..." + request.getRequestURI());
    }

    /**
     * 渲染视图之后被调用，释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
        System.out.println("SpecialInterceptor：afterCompletion..." + request.getRequestURI());
	}
}