package com.example.spring.exercise.controller;

import com.example.spring.exercise.domain.User;
import com.example.spring.exercise.enums.TestEnum;
import com.example.spring.exercise.enums.TestEnum2;
import com.example.spring.exercise.enums.TestEnum3;
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
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //示例：http://localhost:8003/user?userId=1
    @GetMapping(path = "")
    public ResponseEntity getUserByUserId(@RequestParam(value = "userId", defaultValue = "3") String userId){
        User user = userService.getUserByUserId(userId);
        return new ResponseEntity(user,HttpStatus.OK);
    }
    @GetMapping(path = "/testEnum")
    public TestEnum  testEnum(){
        for (TestEnum we : TestEnum.values()) {
            LOGGER.info("TestEnum:"+ we.toString());
        }
        for (TestEnum2 we : TestEnum2.values()) {
            LOGGER.info("TestEnum2:"+ we.toString()+ " "+we.getName()+ " "+we.getYear());
        }
        for (TestEnum3 we : TestEnum3.values()) {
            LOGGER.info("TestEnum3:"+ we.getName());
        }
        return TestEnum.BLUE;
    }
    //{userId}和String userId中userId,要匹配
    //示例：http://localhost:8003/user/1
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
