package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MathewTang
 */
@RestController
public class RedisController {

    /**
     * 注入RedisTemplate
     * <p>
     * RedisTemplate泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     * <p>
     * 注意：RedisTemplate对象的名称 redisTemplate
     *
     * 使用原始类型会报警告信息【老师用的是第三种】
     */
    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * TODO: 添加数据到redis
     * @return {@link String}
     */
    @PostMapping("/redis/add-string")
    public String addToRedis(String name, String value) {
        // 操作Redis中String类型的数据，先获取ValueOperations对象
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();

        // 添加数据到redis
        valueOperations.set("myname", "lisi");

        return "向redis添加string类型的数据";
    }

    /**
     * TODO: 从redis获取数据
     * @return {@link String}
     */
    @GetMapping("/redis/get-string")
    public String getData(String k) {
        // 操作Redis中String类型的数据，先获取ValueOperations对象
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key = " + k + ", value = " + v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKv(@PathVariable String k,
                                @PathVariable String v) {
        // 使用StringRedisTemplate对象
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(k, v);
        return "使用StringRedisTemplate对象";
    }

    @GetMapping("/redis/get-str/{k}")
    public String getStringValue(@PathVariable String k) {
        // 使用StringRedisTemplate对象
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String v = stringStringValueOperations.get(k);
        return "key = " + k + ", value = " + v;
    }

    /**
     * 设置RedisTemplate 序列化
     * 可以设置key 的序列化，可以设置value的序列化
     * 可以同时设置key 和 value的序列化
     */
    @PostMapping("/redis/add-str")
    public String addString(String k, String v) {
        // 使用RedisTemplate
        // 设置 key 使用String的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 设置 value 的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k, v);
        return "定义RedisTemplate对象的key, value的序列化";
    }

    /**
     * 使用json 序列化，把java对象转为json存储
     */
    @PostMapping("/redis/add-json")
    public String addJson() {
        Student student = new Student(1001L, "zhangSan", 20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Student>(Student.class));

        redisTemplate.opsForValue().set("myStudent", student);
        return "json序列化";
    }

    /**
     * 使用json 序列化，把java对象转为json存储
     */
    @PostMapping("/redis/get-json")
    public String getJson() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Student>(Student.class));

        Student student = (Student) redisTemplate.opsForValue().get("myStudent");
        return "json序列化, " + student;
    }
}
