package com.bjpowernode.dao;

import com.bjpowernode.model.Student;

/**
 * @author MathewTang
 */
public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
