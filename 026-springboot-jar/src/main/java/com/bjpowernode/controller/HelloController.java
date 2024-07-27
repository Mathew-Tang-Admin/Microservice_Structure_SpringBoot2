package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MathewTang
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView();
        model.addObject("data", "SpringBoot打包为jar");
        model.setViewName("main");
        return model;
    }

    @RequestMapping("/model")
    public String hello(Model model) {
        model.addAttribute("data", "SpringBoot打包为jar");
        return "forward:/main.jsp";
        // return "forward:/index.html";
    }

}
