package com.bjpowernode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 由于本项目是使用MyBatis逆向工程生成的，所以有不按老师的标准修订了
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;

    private String name;

    private Integer age;

    private Double height;

    private Date birth;

    private String sex;
}
