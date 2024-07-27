package com.bjpowernode;

import com.bjpowernode.config.SpringConfig;
import com.bjpowernode.vo.CatVO;
import com.bjpowernode.vo.StudentVO;
import com.bjpowernode.vo.TigerVO;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MathewTang
 */
public class MyTest {

    /**
     * TODO: 使用xml作为容器配置文件
     */
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentVO student = (StudentVO) ctx.getBean("myStudent");
        System.out.println("容器中的对象：student = " + student);
    }

    /**
     * TODO: 使用JavaConfig
     */
    @Test
    public void test02() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentVO student = (StudentVO) ctx.getBean("createStudent");
        System.out.println("使用JavaConfig创建的bean对象：student = " + student);
    }

    @Test
    public void test03() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentVO student = (StudentVO) ctx.getBean("lisiStudent");
        System.out.println("使用JavaConfig创建的bean对象：student = " + student);
    }

    @Test
    public void test04() {
        // String config = "beans.xml";
        // ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        CatVO cat = (CatVO) ctx.getBean("myCat");
        System.out.println("cat = " + cat);
    }

    @Test
    public void test05() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        TigerVO tiger = (TigerVO) ctx.getBean("tiger");
        System.out.println("tiger = " + tiger);
    }
}
