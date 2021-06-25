package com.example.spring.exercise.service;

import com.example.spring.exercise.dao.TestRedisDao;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestRedisService {

    @Resource
    private TestRedisDao testRedisDao;
    public void saveData() {
        testRedisDao.saveData();
    }

    public String getSaveData() {
        return testRedisDao.getSaveData();
    }
}
