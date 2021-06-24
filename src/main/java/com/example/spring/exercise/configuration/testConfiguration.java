package com.example.spring.exercise.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties(YamlConfig.class)
@Data
public class testConfiguration {

  @Autowired
  private YamlConfig yamlConfig;

  public String getString() {
    return yamlConfig.getString();
  }

}
