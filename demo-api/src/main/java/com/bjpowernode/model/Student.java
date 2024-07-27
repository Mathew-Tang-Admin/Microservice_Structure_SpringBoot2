package com.bjpowernode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 本项目还是使用t_student表
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    /** name至少两个字符 */
    private String name;

    /** phone必须唯一 */
    private String phone;

    /** age 必须 大于 0 */
    private Integer age;

    public static Student defaultStudent() {
        return new Student(0L, "-", "-", 0);
    }
}
