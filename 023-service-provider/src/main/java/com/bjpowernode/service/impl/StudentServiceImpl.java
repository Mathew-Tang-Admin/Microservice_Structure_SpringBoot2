package com.bjpowernode.service.impl;

import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 使用dubbo中的注解暴露服务
 * @author MathewTang
 */
// @Component // 可以不用提供
@DubboService(interfaceClass = StudentService.class, version = "1.0", timeout = 5000)
public class StudentServiceImpl implements StudentService {
    public static final Long ID = 1001L;
    public static final Long ID2 = 1002L;

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    @Override
    public Student queryStudent(Long id) {
        Student student = new Student();
        // if (1001L == id) {
        if (ID.equals(id)) {
            student.setId(id);
            student.setName("1001-张三");
            student.setAge(20);
        }else if (ID2.equals(id)) {
            student.setId(id);
            student.setName("1002-张三");
            student.setAge(20);
        }
        return student;
    }
}
