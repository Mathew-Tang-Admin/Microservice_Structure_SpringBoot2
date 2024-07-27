package com.bjpowernode.service;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author MathewTang
 */
public interface StudentService {

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    Student queryById(@Param("stuId") Long id);

}
