package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MathewTang
 */
@Controller
public class BootController {

    @RequestMapping("/hello")
    @ResponseBody
    public String doSome() {
        return "hello SpringBoot应用，设置了应用上下文路径";
    }
}
