package com.bjpowernode.service.impl;

import com.bjpowernode.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author MathewTang
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "执行sayHello方法：" + name;
    }
}
