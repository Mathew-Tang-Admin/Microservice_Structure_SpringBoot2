package com.bjpowernode.service;

import com.bjpowernode.model.Student;

/**
 * Dubbo对外的功能接口
 * @author MathewTang
 */
public interface StudentService {

    /**
     * TODO: 注册学生
     *     phone必须唯一， 如果已经存在了手机号，注册失败的。
     * @param student Student
     * @return {@link int}
     *     1: 注册成功
     *     2: 手机号已经存在
     *     3: 未填写手机号
     */
    int addStudent(Student student);

    /**
     * TODO: 根据id查询学生
     * @param id Long
     * @return {@link Student}
     */
    Student  queryStudent(Long id);

}
