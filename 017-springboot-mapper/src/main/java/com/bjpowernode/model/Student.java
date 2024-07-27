package com.bjpowernode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关于本项目所用的数据库结构，
 *     id->int, name->varchar, age->int => 这是老师所用的
 *     不过我有相似的环境(t_student)，就不新建了
 * 实体类也同理，和数据库对应
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    /** 主要是本属性有差异 */
    private Long id;
    private String name;
    private Integer age;
}
