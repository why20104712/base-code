package com.example.demo;

import com.example.demo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Before
    public void initRedisTemplate() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

    @Test
    public void contextLoads() {
        RedisSerializer<?> defaultSerializer = redisTemplate.getDefaultSerializer();
        log.warn("spring data redis 默认的序列化方式：{} ", defaultSerializer);
    }


    @Test
    public void set() {
        redisTemplate.opsForValue().set("aa:bb:cc", "dd");
        log.warn("放入aa:bb:cc的值：dd");
        StringBuffer object = new StringBuffer().append("object1").append("object2");
        redisTemplate.opsForValue().set("object", object);
        log.warn("放入object的值：{}", object);

        Person person = new Person();
        person.setAge(1);
        person.setBirthday(new Date());
        person.setDel(Boolean.FALSE);
        person.setEmail("1@@qq.com");
        person.setId(1);
        person.setName("aaa");

        redisTemplate.opsForValue().set("person", person);

        log.warn("放入person的值：{}" , person);
    }


    @Test
    public void get() {
        Object o = redisTemplate.opsForValue().get("aa:bb:cc");
        log.warn("取出aa:bb:c的值：{}", o);
        Object object = redisTemplate.opsForValue().get("object");
        log.warn("取出object的值：{}" , object);

        Object person = redisTemplate.opsForValue().get("person");
        log.warn("取出person的值：{}", person);
    }


    @Test
    public void putHash() {

        redisTemplate.opsForHash().put("person:hash","id",1);
        redisTemplate.opsForHash().put("person:hash","name","ccc");
        redisTemplate.opsForHash().put("person:hash","age",18);
        redisTemplate.opsForHash().put("person:hash","birthday",new Date());

        log.warn("放入hash数据");
    }


    @Test
    public void getHash() {
        Object id = redisTemplate.opsForHash().get("person:hash", "id");
        Object birthday = redisTemplate.opsForHash().get("person:hash", "birthday");
        log.warn("取出hash数据：{} {}", id, birthday);
    }


}
