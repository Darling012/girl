package com.mvc.redis;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.mvc.domain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue()
                        .set("strKey", "adb");
        System.out.println(strRedisTemplate.opsForValue()
                                           .get("strKey"));
    }

    @Test
    public void testSerializable() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 221kb 带包路径  需要序列化 jdk反序列化，若父类没有实现序列化接口，将调用父类无参构造器，且父类属性为null
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        // 22kb  不带包路径
        // redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Girl.class));
        // 52kb 带包路径
        // redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        //46kb 不带包路径
         redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Girl.class));
        // 77kb  带包路径
        // redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());



        Girl girl = new Girl();
        girl.setId(1);
        girl.setCupSize("C");
        redisTemplate.opsForValue()
                     .set("girl", girl);
        Girl user2 = (Girl) redisTemplate.opsForValue()
                                         .get("girl");
        System.out.println("user:" + user2.getId() + "," + user2.getCupSize());
    }

    @Test
    public void contextLoads() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(List.class));
        ValueOperations<String, List<Girl>> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("aaa", Arrays.asList(new Girl(1, "24", 1, 1d), new Girl(2, "30", 1, 1d)));

        List<Girl> p = valueOperations.get("aaa");
        System.out.println(p); //[{name=fsx, age=24}, {name=fff, age=30}]

        List<Girl> aaa = (List<Girl>) redisTemplate.opsForValue().get("aaa");
        System.out.println(aaa); //[{name=fsx, age=24}, {name=fff, age=30}]
    }

    @Test
    public void contextLoadss() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        ValueOperations<String, Long> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("aaa", 1L);
         //转换异常 java.lang.Integer cannot be cast to java.lang.Long
        // Long p = valueOperations.get("aaa");
        Object p = valueOperations.get("aaa");
        System.out.println(p);
    }

    @Test
    public void contextLoadsss() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 没问题
        // redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        // 有问题
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        SetOperations<String, Long> setOperations = redisTemplate.opsForSet();
        setOperations.add("bbb", 1L);
        setOperations.add("bbb", 2L);

        Set<Long> p = setOperations.members("bbb");
        setOperations.pop("bbb");
        System.out.println(p);

        Long longValue = 123L;
        redisTemplate.opsForValue()
                     .set("cacheLongValue", longValue);
        Object cacheValue = redisTemplate.opsForValue()
                                         .get("cacheLongValue");
        Long a = (Long) cacheValue;
        System.out.println(a);
    }
}
