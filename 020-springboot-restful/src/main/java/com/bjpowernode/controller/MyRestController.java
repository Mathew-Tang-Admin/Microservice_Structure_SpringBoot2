package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author MathewTang
 */
@Controller
public class MyRestController {

    // 学习注解的使用

    /**
     * TODO: 查询id=1001的学生
     * @PathVariable(路径变量): 获取url中的数据 <br/>
     *     属性：value：定义路径变量的 <br/>
     *     位置：放在控制器方法的形参前面 <br/>
     *
     * http://localhost:8080/myBoot/student/1002
     * <br/>
     * {stuId}: 定义路径变量，stuId自定义名称
     * @return {@link String}
     */
    @GetMapping("/student/{stuId}")
    @ResponseBody
    public String queryStudent(@PathVariable("stuId") Long id) {
        return "查询学生studentId=" + id;
    }

    /** http://localhost:8080/myBoot/student/20 */
    @PostMapping("/student/{age}")
    @ResponseBody
    public String queryStudentByAge(@PathVariable("age") Integer age) {
        return "查询学生age=" + age;
    }

    /**
     * TODO: 创建资源，POST请求方式
     * http://localhost:8080/myBoot/student/张三/23
     * @param name String
     * @param age Integer
     * @return {@link String}
     */
    @PostMapping("/student/{name}/{age}")
    @ResponseBody
    public String createStudent(@PathVariable("name") String name,
                                @PathVariable("age") Integer age) {
        return "创建资源，student：name=" + name + "#age=" + age;
    }

    /**
     * TODO: 更新资源
     * <p>
     * 当路径变量和 形参名相同时，@PathVariable中的value可以省略不写
     * @param id Integer
     * @param age Integer
     * @return {@link String}
     */
    @PutMapping("/student/{id}/{age}")
    @ResponseBody
    public String modifyStudent(@PathVariable Integer id,
                                @PathVariable Integer age) {
        return "更新资源，执行put请求方式：id=" + id + "#age=" + age;
    }

    /**
     * TODO: 删除资源
     * @param id Integer
     * @return {@link String}
     */
    @DeleteMapping("/student/{id}")
    @ResponseBody
    public String removeStudentById(@PathVariable Integer id) {
        return "删除资源，执行delete请求方式：id=" + id;
    }

    // @RequestMapping(value = "/student/test", method = RequestMethod.PUT)
    @PutMapping("/student/test")
    @ResponseBody
    public String test() {
        return "执行student/test，使用的请求方式 put";
    }

    @DeleteMapping("/student/test-delete")
    @ResponseBody
    public String testDelete() {
        return "执行student/test-delete，使用的请求方式 delete";
    }

}
