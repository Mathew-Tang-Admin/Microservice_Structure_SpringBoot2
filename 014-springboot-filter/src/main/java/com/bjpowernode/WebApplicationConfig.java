package com.bjpowernode;

import com.bjpowernode.web.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MathewTang
 */
@Configuration
public class WebApplicationConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> filterFilterRegistrationBean() {

        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/user/*");
        return bean;
    }
}
