package com.example.spring.exercise.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/security")
public class TestSecurityController {
    @GetMapping("user")
    @PreAuthorize("hasRole('USER')")
    public int testSecurity(){
        return 1;
    }
    @GetMapping("user2")
    @PreAuthorize("hasRole('USER2')")
    public int testSecurity2(){
        return 2;
    }
}