package com.example.spring.exercise.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties(YamlConfig.class)
public class testConfiguration {
    @Autowired
    private YamlConfig yamlConfig;
    public void setYamlConfig(YamlConfig yamlConfig) {
        this.yamlConfig = yamlConfig;
    }
    public YamlConfig getYamlConfig() {
        return yamlConfig;
    }

    public String getString(){
        return yamlConfig.getString();
    }

}
