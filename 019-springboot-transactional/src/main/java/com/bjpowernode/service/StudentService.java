package com.bjpowernode.service;

import com.bjpowernode.model.Student;

/**
 * @author MathewTang
 */
public interface StudentService {

    /**
     * TODO: 此处待完成
     * @param student Student
     * @return {@link Long}
     */
    int addStudent(Student student);

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    Student queryById(Long id);

}
