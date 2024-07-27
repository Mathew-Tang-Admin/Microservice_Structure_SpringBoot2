package com.bjpowernode.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author MathewTang
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行了MyFilter的doFilter，" + ((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }
}
