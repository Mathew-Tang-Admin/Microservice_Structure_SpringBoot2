package com.bjpowernode.model;

/**
 * 本类是我自主定义的
 * @author MathewTang
 */
public class StudentConstant {

    /**
     * 添加成功
     * StudentServiceImpl.addStudent()方法使用
     */
    public static final Integer REGISTRY_RETURN_SUCCESS = 1;

    /**
     * 手机号已存在
     * StudentServiceImpl.addStudent()方法使用
     */
    public static final Integer REGISTRY_RETURN_PHONE_EXISTENCE = 2;

    /**
     * 未填写手机号
     * StudentServiceImpl.addStudent()方法使用
     */
    public static final Integer REGISTRY_RETURN_PHONE_NOT_FILLED = 3;
}
