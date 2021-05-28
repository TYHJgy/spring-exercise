package com.example.spring.exercise.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(YamlConfig.class)
@Data
public class TestConfiguration {
    @Autowired
    private YamlConfig yamlConfig;

    public String getString(){
        return yamlConfig.getString();
    }

}
