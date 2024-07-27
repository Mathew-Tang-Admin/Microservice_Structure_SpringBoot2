package com.bjpowernode.service.impl;

import com.bjpowernode.service.StudentService;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
// @Service("studentService")
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryById(Long id) {
        return studentDao.selectById(id);
    }
}
