package com.bjpowernode.dao;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 告诉Mybatis这是dao接口，创建此接口的代理对象
 *     位置：在类的上面
 * @author MathewTang
 */
@Mapper
public interface StudentDao {

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    Student selectById(@Param("stuId") Long id);
}
