package com.bjpowernode.config;

import com.bjpowernode.vo.StudentVO;
import org.springframework.context.annotation.*;

/**
 * Configuration:表示当前类是作为配置文件使用的。 就是用来配置容器的
 *     位置：在类的上面
 *
 * SpringConfig这个类就相当于beans.xml
 *
 * @author MathewTang
 */
@Configuration
@ImportResource(value = "classpath:application-context.xml")
@PropertySource(value = "classpath:config.properties")
@ComponentScan(basePackages = "com.bjpowernode.vo")
public class SpringConfig {

    /**
     * 创建方法，方法的返回值是对象。 在方法的上面加入@Bean
     * 方法的返回值对象就注入到容器中。
     *
     * @Bean: 把对象注入到spring容器中。 作用相当于<bean>
     *
     *     位置：方法的上面
     *     说明：@Bean,不指定对象的名称，默认是方法名是 id(方法名，我觉得应该是这个)
     *
     */
    @Bean
    public StudentVO createStudent() {
        StudentVO s1 = new StudentVO();
        s1.setName("张三");
        s1.setAge(26);
        s1.setSex("男");
        return s1;
    }

    /**
     * 指定对象在容器中的名称（指定<bean>的id属性）
     */
    @Bean(name = "lisiStudent")
    public StudentVO makeStudent() {
        StudentVO s2 = new StudentVO();
        s2.setName("李四");
        s2.setAge(22);
        s2.setSex("男");
        return s2;
    }
}
