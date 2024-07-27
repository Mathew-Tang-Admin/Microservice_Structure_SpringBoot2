package com.bjpowernode.config;

import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MathewTang
 */
@Configuration
public class WebSystemConfig {

    /**
     * TODO: 注册Servlet
     * @return {@link ServletRegistrationBean<MyServlet>}
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        ServletRegistrationBean<MyServlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new MyServlet());
        reg.addUrlMappings("/myServlet");
        return reg;
    }

}
