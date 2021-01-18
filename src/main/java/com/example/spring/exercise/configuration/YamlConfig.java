package com.example.spring.exercise.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix="my")
public class YamlConfig {

    private List<String> servers;

    public String getString(){
        return "getString";
    }
}
