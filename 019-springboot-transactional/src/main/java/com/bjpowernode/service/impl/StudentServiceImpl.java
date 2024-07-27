package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentMapper;
import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    /**
     * TODO: @Transactional表示方法有事务支持
     *     默认：使用数据库的隔离级别，REQUIRED 传播行为；超时时间 -1
     *     抛出运行时异常，回滚事务
     * @param student Student
     * @return {@link Long}
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int addStudent(Student student) {
        System.out.println("业务方法addStudent");
        int count = studentMapper.insert(student);
        System.out.println("执行sql语句");

        // 抛出运行时异常，目的是回滚事务
        // int m = 10/0;

        return count;
    }

    /**
     * TODO: 此处待完成
     * @param id Long
     * @return {@link Student}
     */
    @Override
    public Student queryById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
