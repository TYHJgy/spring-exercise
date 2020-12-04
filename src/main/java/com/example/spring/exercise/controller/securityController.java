package com.example.spring.exercise.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
@RequestMapping(path="/security")
public class securityController{
    @GetMapping()
    @PreAuthorize("hasRole('USER')")
    public int testSecurity(){
        return 0;
    }

}