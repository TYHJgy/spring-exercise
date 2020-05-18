package com.example.spring.exercise.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@ConfigurationProperties(prefix="my.config")
public class ConfigurationController {
    @Value("${name}")
    private String name;
    private String name2;
    private String random;

    public String getName() {
        return name;
    }
    public String getName2() {
        return name2;
    }
    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public void setName(String name) {
        this.name = name;
    }

    @GetMapping("")
    public String getConfigPara(){
        return getName();
    }
    @GetMapping("/2")
    public String getConfigPara2(){
        return getName2();
    }
    @GetMapping("/random")
    public String getConfigParaRandom(){
        return getRandom();
    }
}
