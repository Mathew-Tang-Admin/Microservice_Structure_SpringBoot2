package com.bjpowernode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        boolean flag = ((10 % 2) == 1) && ((10 / 3) == 0) && ((1 / 0) == 0);
        System.out.println(flag ? "mldn" : "yootk");
    }

}
