package com.example.spring.exercise.service;

import org.springframework.stereotype.Service;


@Service
public class AopByMethodService {
    public void add() {
        System.out.println("AopByMethodService.add()");
    }
}