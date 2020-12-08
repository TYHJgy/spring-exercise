package com.example.spring.exercise.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Configuration
@ConfigurationProperties(prefix="my")
public class YamlConfig {
    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }
    public String getString(){
        return "getString";
    }
}
