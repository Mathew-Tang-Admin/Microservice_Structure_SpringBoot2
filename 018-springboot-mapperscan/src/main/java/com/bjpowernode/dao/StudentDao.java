package com.bjpowernode.dao;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author MathewTang
 */
public interface StudentDao {

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    Student selectById(@Param("stuId") Long id);
}
