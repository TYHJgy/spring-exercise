/*
*/
package com.example.spring.exercise.controller;

import com.example.spring.exercise.domain.User;
import com.example.spring.exercise.service.UserService;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/user")
public class ApiUserController {
    private User userName;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUserName() {
        return userName;
    }
    //@Autowired
    public void setUserName(User userName) {
        this.userName = userName;
    }

    @GetMapping(path = "")
    public User getUserByUserId(@RequestParam(value = "userId", defaultValue = "1") String userId){
        System.out.println("getUserByUserId");
        return userService.getUserByUserId(userId);
    }
    //{userId}和String userId中userId,要匹配
    @RequestMapping("/{userId}")
    public User getUserByUserId2(@PathVariable String userId){
        System.out.println("getUserByUserId2");
        return userService.getUserByUserId(userId);
    }
    @GetMapping("/{userId}")
    public User getUserByUserId3(@PathVariable String userId){
        System.out.println("getUserByUserId3");
        return userService.getUserByUserId(userId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.insertUserTotTab(user);
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
