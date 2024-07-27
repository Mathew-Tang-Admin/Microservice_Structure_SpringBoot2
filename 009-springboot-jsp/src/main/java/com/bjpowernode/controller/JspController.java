package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MathewTang
 */
@Controller
public class JspController {

    @RequestMapping("/hello")
    @ResponseBody
    public String doSome(HttpServletRequest request) {
        /* request.setAttribute("data", "SpringBoot使用jsp");
        // 视图的逻辑名称
        return "text"; */
        return "Hello";
    }

    /**
     * TODO: ModelAndView
     * @param model Model
     * @return {@link String}
     */
    @RequestMapping("/myJsp")
    public String doJsp(Model model) {
        // 把数据放入到request作用域
        model.addAttribute("data", "SpringBoot使用jsp");
        // 视图的逻辑名称
        return "index";
    }

}
