package com.bjpowernode.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * @author MathewTang
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * TODO: 此处待完成
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Object，被拦截的控制器对象
     * @return {@link boolean}
     *     true：请求能被controller处理
     *     false：请求被截断
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler) throws Exception {
        System.out.println("执行了LoginInterceptor的preHandler()方法，" + request.getRequestURI());
        return true;
    }
}
