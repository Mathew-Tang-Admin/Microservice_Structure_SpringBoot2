package com.bjpowernode.config;

import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MathewTang
 */
@Configuration
public class WebApplicationConfig {

    /**
     * TODO: 定义方法，注册Servlet对象
     * @return {@link ServletRegistrationBean<MyServlet>}
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {

        // public ServletRegistrationBean(T servlet, String... urlMappings)
        // 第一个参数是 Servlet对象， 第二个是url地址

        /* ServletRegistrationBean<MyServlet> bean =
                new ServletRegistrationBean<>(new MyServlet(), "/myServlet"); */

        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/login", "/test"); // <url-pattern></url-pattern>

        return bean;
    }

}
