package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MathewTang
 */
@Controller
public class CustomFilterController {

    @RequestMapping("/user/account")
    @ResponseBody
    public String userAccount() {
        return "/user/account";
    }

    @RequestMapping("/query")
    @ResponseBody
    public String queryAccount() {
        return "/query";
    }

}
