package com.example.spring.exercise.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.spring.exercise.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}