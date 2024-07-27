package com.bjpowernode;

import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private UserService userService;

    public static void main(String[] args) {
        System.out.println("准备创建容器对象");
        // 创建容器对象
        SpringApplication.run(Application.class, args);
        System.out.println("容器对象创建之后");
    }

    @Override
    public void run(String... args) throws Exception {
        String str = userService.sayHello("jacket");
        System.out.println("调用容器中的对象，" + str);
        // 可以做自定义的操作，比如读取文件，数据库等等
        System.out.println("容器对象创建好，执行的方法");
    }
}
