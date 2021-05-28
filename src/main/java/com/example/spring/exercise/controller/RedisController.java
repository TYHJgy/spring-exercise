package com.example.spring.exercise.controller;

import com.example.spring.exercise.service.TestRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;

@RestController
@RequestMapping(path="/testRedis")
public class RedisController {

    @Autowired
    private TestRedisService testRedisService;

    @GetMapping("save")
    public void testRedis(){
        testRedisService.saveData();
    }
    @GetMapping("get")
    public String testRedis_get(){
        return testRedisService.getSaveData();
    }
}
