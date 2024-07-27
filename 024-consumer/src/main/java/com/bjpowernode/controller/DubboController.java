package com.bjpowernode.controller;

import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MathewTang
 */
@RestController
public class DubboController {

    /**
     * 引用远程服务，把创建好的代理对象，注入给studentService
     */
    // @DubboReference(interfaceClass = StudentService.class, version = "1.0")
    /**
     * 没有使用interfaceClass，默认就是，引用类型的 数据类型
     */
    @DubboReference(version = "1.0")
    private StudentService studentService;

    @GetMapping("/query")
    public String queryStudent(Long id) {
        Student student = studentService.queryStudent(id);
        return "调用远程接口，获取对象：" + student;
    }

}
