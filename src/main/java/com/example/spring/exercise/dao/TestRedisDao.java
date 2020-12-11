package com.example.spring.exercise.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestRedisDao {
    private StringRedisTemplate template;

    public StringRedisTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }

    public void saveData(){
        template.opsForValue().set("test1","ttteeesssttt");
    }

    public String getSaveData() {
        return template.opsForValue().get("test1");
    }
}
