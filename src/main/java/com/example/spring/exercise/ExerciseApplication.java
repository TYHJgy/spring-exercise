package com.example.spring.exercise;

import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

/*
If you don’t want to use @SpringBootApplication, the @EnableAutoConfiguration and @ComponentScan annotations
that it imports defines that behaviour so you can also use those instead.
*/
@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(ExerciseApplication.class);
        /**
         * OFF G关闭
         * CLOSED 后台控制台输出，默认就是这种
         * LOG 日志输出
         */
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }
    /*应用程序退出时（执行SpringApplication.exit()）会调用该方法*/
    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }
}
