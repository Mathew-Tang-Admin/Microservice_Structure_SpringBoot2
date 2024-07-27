package com.bjpowernode.controller;

import com.bjpowernode.vo.SchoolInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
@Controller
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${school.name}")
    private String name;

    @Value("${site}")
    private String site;

    /** Resource是java提供的，autowired是spring提供的，resource首先通过名称，再通过类型，比autowired好用 */
    @Resource
    private SchoolInfo schoolInfo;

    @RequestMapping("/data")
    @ResponseBody
    public String queryData() {
        return name + " , site = " + site + " , 项目的访问地址 = " + contextPath + ", 使用的端口 = /" + port;
    }

    @RequestMapping("/school")
    @ResponseBody
    public String querySchoolInfo() {
        return schoolInfo.toString();
    }
}
