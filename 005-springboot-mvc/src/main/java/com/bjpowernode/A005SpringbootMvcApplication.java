package com.bjpowernode;

import com.bjpowernode.vo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class A005SpringbootMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(A005SpringbootMvcApplication.class, args);
    }

    /**
     * TODO: 声明对象，对象能注入到容器
     * @return {@link Student}
     */
    @Bean
    public Student myStudent() {
        Student student = new Student();
        return student;
    }

}
