package com.example.spring.exercise.service;

import com.example.spring.exercise.dao.UserDao;
import com.example.spring.exercise.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByUserId(String userId){
        return userDao.selectUserByUserId(userId);
    }
    public void insertUserTotTab(User user){
        int r = userDao.insertUser(user);
        System.out.println("userDao.insertUser="+r);
    }
    public void updateUserbyId(User user){
        int r = userDao.updateUser(user);
        System.out.println("userDao.insertUser="+r);
    }
    public void deleteUserByUid(String uid){
        userDao.deleteUser(uid);
    }
}
