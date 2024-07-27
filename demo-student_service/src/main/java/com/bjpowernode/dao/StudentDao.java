package com.bjpowernode.dao;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author MathewTang
 */
// @Mapper
public interface StudentDao {

    /**
     * TODO: 按手机号查询学生
     * @param phone String
     * @return {@link Student}
     */
    Student selectStudentByPhone(@Param("phone") String phone);


    /**
     * TODO: 注册学生
     *     phone必须唯一， 如果已经存在了手机号，注册失败的。
     * @param student Student
     * @return {@link int}
     */
    int insertStudent(Student student);

    /**
     * TODO: 根据id查询学生
     * @param id Long
     * @return {@link Student}
     */
    Student  queryStudent(@Param("id") Long id);

}
