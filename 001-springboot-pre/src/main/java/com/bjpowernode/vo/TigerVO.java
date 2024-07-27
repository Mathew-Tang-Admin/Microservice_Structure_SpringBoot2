package com.bjpowernode.vo;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MathewTang
 */
@Component("tiger")
@ToString
public class TigerVO {
    @Value("${tiger.name}")
    private String name;
    @Value("${tiger.age}")
    private int age;
}
