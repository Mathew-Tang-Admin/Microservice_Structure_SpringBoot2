package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MathewTang
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot() {
        return "欢迎使用SpringBoot框架";
    }
}
