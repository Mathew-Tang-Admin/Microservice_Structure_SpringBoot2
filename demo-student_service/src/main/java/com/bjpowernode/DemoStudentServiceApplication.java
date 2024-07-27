package com.bjpowernode;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 老师的是com.bjpowernode.demo.dao
 * @author MathewTang
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.bjpowernode.dao")
public class DemoStudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStudentServiceApplication.class, args);
    }

}
