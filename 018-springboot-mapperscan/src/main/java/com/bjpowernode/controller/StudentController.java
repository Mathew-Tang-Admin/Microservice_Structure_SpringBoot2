package com.bjpowernode.controller;

import com.bjpowernode.service.StudentService;
import com.bjpowernode.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/student/query")
    @ResponseBody
    public String hello(Long id) {
        Student student = studentService.queryById(id);
        return student.toString();
    }

}
