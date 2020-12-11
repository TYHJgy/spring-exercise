package com.example.spring.exercise.service;

import com.example.spring.exercise.dao.TestRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestRedisService {

    @Autowired
    private TestRedisDao testRedisDao;
    public void saveData() {
        testRedisDao.saveData();
    }

    public String getSaveData() {
        return testRedisDao.getSaveData();
    }
}
