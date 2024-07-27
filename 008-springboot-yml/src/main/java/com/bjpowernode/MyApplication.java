package com.bjpowernode;

import com.bjpowernode.vo.SchoolInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author MathewTang
 */
@SpringBootApplication
// @EnableConfigurationProperties(SchoolInfo.class)
// @ConfigurationPropertiesScan(basePackages = "com.bjpowernode.vo")
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
