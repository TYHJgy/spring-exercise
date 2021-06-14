package com.example.spring.exercise.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	//声明当前类是一个配置类，相当于 Spring 中的一个 XML 文件
public class MvcConfig implements WebMvcConfigurer {
    private final static Logger LOGGER = LoggerFactory.getLogger(MvcConfig.class);

	public void addViewControllers(ViewControllerRegistry registry) {
        LOGGER.info("enter addViewControllers");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

}
