package com.bjpowernode.controller;

import com.bjpowernode.model.SysUser;
import com.bjpowernode.vo.Cat;
import com.bjpowernode.vo.Dog;
import com.bjpowernode.vo.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author MathewTang
 */
@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    /**
     * TODO: 标准变量表达式
     * @param model Model
     * @return {@link String}
     */
    @GetMapping("/expression1")
    public String expression1(Model model) {
        model.addAttribute("site", "www.bjpowernode.com");
        model.addAttribute("myuser", new SysUser(1001, "李四", "男", 20));

        // 指定视图
        return "expression1";
    }

    /**
     * TODO: 选择变量表达式
     * @param model Model
     * @return {@link String}
     */
    @GetMapping("/expression2")
    public String expression2(Model model) {
        model.addAttribute("site", "www.bjpowernode.com");
        model.addAttribute("myuser", new SysUser(1001, "李四", "男", 20));

        // 指定视图
        return "expression2";
    }

    /**
     * TODO: 链接表达式
     * @param model Model
     * @return {@link String}
     */
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("userId", 1002);
        return "link";
    }

    /**
     * TODO: 测试链接表达式的地址
     * @param id Integer
     * @return {@link String}
     */
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id) {
        return "queryAccount, 参数id=" + id;
    }

    /**
     * TODO: 有两个参数的地址
     * @return {@link String}
     */
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name, Integer age) {
        return "queryAccount, 参数name=" + name + ", age=" + age;
    }

    /**
     * TODO: 使用模板的属性
     * @return {@link String}
     */
    @GetMapping("/property")
    public String useProperty(Model model) {
        model.addAttribute("methodAttr", "post");
        model.addAttribute("id", "2342");

        model.addAttribute("paramName", "name");
        model.addAttribute("userValue", "lisi");

        model.addAttribute("textColor", "color: green");

        return "html-property";
    }

    /**
     * TODO: 循环List
     * @return {@link String}
     */
    @GetMapping("/eachList")
    public String eachList(Model model) {
        List<Object> list = new ArrayList<>();
        list.add(new SysUser(1001,"薛平","男",9));
        list.add(new SysUser(1002,"戴芳","男",51));
        list.add(new SysUser(1003,"崔伟","女",94));
        list.add(new SysUser(1004,"于丽","女",79));
        list.add(new SysUser(1005,"徐涛","女",88));

        model.addAttribute("userList", list);
        return "eachList";
    }

    /**
     * TODO: 循环Array
     * @return {@link String}
     */
    @GetMapping("/eachArray")
    public String eachArray(Model model) {
        SysUser[] sysUsers = new SysUser[5];
        sysUsers[0] = new SysUser(1001,"袁勇","女",63);
        sysUsers[1] = new SysUser(1002,"郭勇","女",93);
        sysUsers[2] = new SysUser(1003,"汪芳","女",82);
        sysUsers[3] = new SysUser(1004,"董明","男",48);
        sysUsers[4] = new SysUser(1005,"崔艳","女",8);

        model.addAttribute("userArray", sysUsers);
        return "eachArray";
    }

    /**
     * TODO: 循环Map
     * @return {@link String}
     */
    @GetMapping("/eachMap")
    public String eachMap(Model model) {
        Map<String, SysUser> map = new HashMap<>();
        map.put("user1", new SysUser(1001,"康秀兰","男",89));
        map.put("user2", new SysUser(1002,"卢勇","男",99));
        map.put("user3", new SysUser(1003,"毛平","女",71));
        map.put("user4", new SysUser(1004,"余敏","男",57));
        map.put("user5", new SysUser(1005,"史艳","男",21));
        model.addAttribute("userMap", map);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("str1", " Hello SpringBoot");
        stringMap.put("str2", "MyBatis MySQL");
        model.addAttribute("stringMap", stringMap);

        // 复杂Map
        List<Map<String, SysUser>> mapList = new ArrayList<>();
        mapList.add(map);

        Map<String, SysUser> customerMap = new HashMap<>();
        map.put("customer1", new SysUser(1021,"萧平","女",76));
        map.put("customer2", new SysUser(1022,"任艳","男",16));
        map.put("customer3", new SysUser(1023,"苏洋","男",69));
        map.put("customer4", new SysUser(1024,"孟超","男",29));
        map.put("customer5", new SysUser(1025,"姜霞","男",46));
        mapList.add(customerMap);

        model.addAttribute("mapList", mapList);

        return "eachMap";
    }

    /**
     * TODO: if-unless
     * @return {@link String}
     */
    @GetMapping("/if-unless")
    public String ifUnless(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("isLogin", true);
        model.addAttribute("age", 20);
        model.addAttribute("name", "卢勇");
        model.addAttribute("cname", "");
        model.addAttribute("isOld", null);

        return "if-unless";
    }

    /**
     * TODO: switch
     * @return {@link String}
     */
    @GetMapping("/switch")
    public String doSwitch(Model model) {
        model.addAttribute("sex", "男");
        return "switch";
    }

    /**
     * TODO: inline
     * @return {@link String}
     */
    @GetMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("age", 20);
        model.addAttribute("name", "卢勇");
        model.addAttribute("myUser", new SysUser(1005,"徐涛","女",88));
        return "inline";
    }

    /**
     * TODO: literal(text), 字面量
     * @return {@link String}
     */
    @GetMapping("/literal(text)")
    public String literal(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("age", 20);
        model.addAttribute("name", "卢勇");
        model.addAttribute("city", "慈溪市");
        model.addAttribute("isLogin", true);
        model.addAttribute("myUser", new SysUser(1005,"徐涛","女",88));
        return "literal(text)";
    }

    /**
     * TODO: 字符串连接
     * @return {@link String}
     */
    @GetMapping("/stringConcatenation")
    public String stringConcatenation(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("age", 20);
        model.addAttribute("name", "孟超");
        model.addAttribute("city", "慈溪市");
        model.addAttribute("isLogin", true);
        model.addAttribute("myUser", new SysUser(1005,"徐涛","女",88));
        return "stringConcatenation";
    }

    /**
     * TODO: 运算符使用
     * @return {@link String}
     */
    @GetMapping("/operatorUsage")
    public String operatorUsage(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("age", 20);
        model.addAttribute("name", "孟超");
        model.addAttribute("city", "慈溪市");
        model.addAttribute("isLogin", true);
        model.addAttribute("myUser", null);
        return "operatorUsage";
    }

    /**
     * TODO: 模板内置对象
     * @return {@link String}
     */
    @GetMapping("/baseObjects")
    public String baseObjects(Model model, HttpServletRequest request,
                            HttpSession session) {
        // 添加数据
        model.addAttribute("myName", "赵秀兰");
        request.setAttribute("requestData", "request作用域中的数据");
        request.getSession().setAttribute("sessionData", "session作用域中的数据");
        // 直接使用session
        session.setAttribute("loginName", "潘娟");

        return "baseObjects";
    }

    /**
     * TODO: 内置的工具类对象
     * @return {@link String}
     */
    @GetMapping("/utilObjects")
    public String utilObjects(Model model) {
        model.addAttribute("myDate", new Date());
        model.addAttribute("myNum", 26.695);
        model.addAttribute("myStr", "bjpowernode");

        List<String> list = Arrays.asList("a", "b", "c");
        model.addAttribute("myList", list);

        // 创建Zoo对象
        Cat cat = new Cat("短腿");
        Dog dog = new Dog("二哈");

        Zoo zoo = new Zoo(cat, dog);
        model.addAttribute("zoo", zoo);

        return "utilObjects";
    }

    /**
     * TODO: 自定义模板
     * @return {@link String}
     */
    @GetMapping("/custom")
    public String custom(Model model, HttpServletRequest request,
                            HttpSession session) {

        // model.addAttribute("zoo", zoo);

        return "custom";
    }
}
