package com.example.spring.exercise.service;

import com.example.spring.exercise.aop.Action;
import org.springframework.stereotype.Service;

@Service
public class AopByAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add() {
        System.out.println("AopByAnnotationService.add()");
    }
}