package com.example.spring.exercise.controller;

import com.example.spring.exercise.domain.User;
import com.example.spring.exercise.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/user")
public class ApiUserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ApiUserController.class);
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public ResponseEntity getUserByUserId(@RequestParam(value = "userId", defaultValue = "3") String userId){
        User user = userService.getUserByUserId(userId);
        return new ResponseEntity(user,HttpStatus.OK);
    }
    //{userId}和String userId中userId,要匹配
    @GetMapping("/{userId}")
    public User getUserByUserId3(@PathVariable String userId){
        LOGGER.info("getUserByUserId3");
        return userService.getUserByUserId(userId);
    }
    @GetMapping(path="all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/{userId}")
    public User getUserByUserId2(@PathVariable String userId){
        LOGGER.info("getUserByUserId2");
        return userService.getUserByUserId(userId);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addUser(@RequestBody User user) {
        userService.insertUserTotTab(user);
        return new ResponseEntity( HttpStatus.OK);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUserbyId(@RequestBody User user){
        userService.updateUserbyId(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserByUid(@PathVariable String userId){
        userService.deleteUserByUid(userId);
    }
}
