package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.model.Student;
import com.bjpowernode.model.StudentConstant;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * 暴露Dubbo的服务
 * @author MathewTang
 */
@DubboService(interfaceClass = StudentService.class, version = "1.0", timeout = 5000)
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * TODO: 注册学生
     *     phone必须唯一， 如果已经存在了手机号，注册失败的。
     * @param student Student
     * @return {@link int}
     *     1: 注册成功
     *     2: 手机号已经存在
     *     3: 未填写手机号
     */
    @Override
    public int addStudent(Student student) {
        // 查询手机号是否唯一
        if(student.getPhone() != null) {
            Student studentByPhone = studentDao.selectStudentByPhone(student.getPhone());
            if (studentByPhone != null) {
                return StudentConstant.REGISTRY_RETURN_PHONE_EXISTENCE; // 老师是使用 int result = 0; result = 2;
            } else {
                int count = studentDao.insertStudent(student);
                return count != 0 ? StudentConstant.REGISTRY_RETURN_SUCCESS : 0;
            }
        }else {
            return StudentConstant.REGISTRY_RETURN_PHONE_NOT_FILLED;
        }
    }

    /**
     * TODO: 根据id查询学生
     *     缓存穿透
     * @param id Long
     * @return {@link Student}
     */
    @Override
    public Student queryStudent(Long id) {
        // redis查询Student, 使用Json存储对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 值存储为Json
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Student>(Student.class));

        final String USER_KEY = "STUDENT:";

        Student student = null;
        if (id != null) {
            // STUDENT:1001
            String key = USER_KEY + id;
            student = (Student) redisTemplate.opsForValue().get(key);
            System.out.println(id + ", 从redis查询数据 " + student);
            if (student == null) {
                // 从MyBatis查询
                student = studentDao.queryStudent(id);
                if (student != null) {
                    // 存到redis
                    redisTemplate.opsForValue().set(key, student);
                } else {
                    // 数据库查不到, 在redis中添加一个此 id 默认值
                    redisTemplate.opsForValue().set(key, Student.defaultStudent());
                }
            }
        }

        return student;
    }
}
