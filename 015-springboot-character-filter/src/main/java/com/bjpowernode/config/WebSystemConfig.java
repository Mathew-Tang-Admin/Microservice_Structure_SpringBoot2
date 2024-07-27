package com.bjpowernode.config;

import com.bjpowernode.web.MyFilter;
import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

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

    /**
     * TODO: 注册Filter
     * @return {@link FilterRegistrationBean<MyFilter>}
     */
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> reg = new FilterRegistrationBean<>();

        // 使用框架中的过滤器类
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        // 指定使用的编码方式
        filter.setEncoding("UTF-8");
        // 指定request，response都使用encoding的值
        filter.setForceEncoding(true);

        reg.setFilter(filter);
        // 指定过滤的url地址
        reg.addUrlPatterns("/*");
        return reg;
    }

}
