package com.example.spring.exercise.controller;

import javax.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/testRedis")
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("saveString")
    public void saveString(){
        stringRedisTemplate.opsForValue().set("test1","ttteeesssttt");
    }
    @GetMapping("getString")
    public String getString(){
        return stringRedisTemplate.opsForValue().get("test1");
    }
}
