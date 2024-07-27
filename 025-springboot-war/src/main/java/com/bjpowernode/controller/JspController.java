package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MathewTang
 */
@Controller
public class JspController {

    @GetMapping("/main")
    public String jsp(Model model) {
        model.addAttribute("data", "SpringBoot打包为war文件");
        return "index";
    }

}
