package com.bjpowernode.controller;

import com.bjpowernode.model.Student;
import com.bjpowernode.model.StudentConstant;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
@Controller
public class DubboController {

    @DubboReference(interfaceClass = StudentService.class, version = "1.0")
    private StudentService studentService;

    @PostMapping("/student/add")
    @ResponseBody
    public String addStudent(Student student) {
        //  对student的数据做处理，name：必填，phone、age：必填
        int result = studentService.addStudent(student);
        String msg = "请稍后处理";
        if (result == StudentConstant.REGISTRY_RETURN_SUCCESS) {
            msg = "添加学生：" + student.getName() + ", 成功";
        }else if (result == StudentConstant.REGISTRY_RETURN_PHONE_EXISTENCE) {
            msg = student.getName() + ", 此手机号已注册，请更换手机号";
        }else if (result == StudentConstant.REGISTRY_RETURN_PHONE_NOT_FILLED) {
            msg = "未填写手机号";
        }
        return "消费者添加学生: " + msg;
    }

    @GetMapping("/student/query")
    @ResponseBody
    public String queryStudent(Long id) {
        String msg = "";
        Student student = null;
        if (id != null && id > 0) {
            student = studentService.queryStudent(id);
            if (student != null) {
                msg = "查询的学生信息：" + student;
            }else {
                msg = "没有查询到";
            }
        }else {
            msg = "查询的id不正确";
        }
        return msg;
    }


}
