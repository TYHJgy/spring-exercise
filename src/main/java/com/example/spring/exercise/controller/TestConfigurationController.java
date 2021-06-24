package com.example.spring.exercise.controller;

import com.example.spring.exercise.configuration.YamlConfig;
import com.example.spring.exercise.configuration.testConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//import lombok.Data;
@RestController
@RequestMapping("/config")
@ConfigurationProperties(prefix = "my.config") //前缀为"my.config"的配置。
//@Data//@Data可以为类提供读写功能，从而不用写get、set方法。
public class TestConfigurationController {

  private String name;    //配置在"application.properties"中 name=gy，前缀不是"my.config"，结果为null
  @Value("${name}")
  private String name2;   //配置在"application.properties"中 name2=gy2，前缀不是"my.config"，需要添加注解 @Value("${name}")
  @Value("gaoyang")
  private String name3;   //配置在@Value("gaoyang") my.config.name3=gy3
  @Value("gy4")
  private String name4;   //配置在@Value("gy4")
  private String random;  //配置在"application.properties"中 my.config.random=${random.int}
  private List<String> servers = new ArrayList<String>();

  @Autowired
  private YamlConfig yamlConfig; //配置文件"application.yml"的配置操作

  @Autowired
  private testConfiguration testConfig;


  public testConfiguration getTestConfig() {
    return testConfig;
  }

  public void setTestConfig(testConfiguration testConfig) {
    this.testConfig = testConfig;
  }

  public String getName() {
    return name;
  }

  public String getName2() {
    return name2;
  }

  public String getRandom() {
    return random;
  }

  public String getName4() {
    return name4;
  }

  public String getName3() {
    return name3;
  }

  public YamlConfig getYamlConfig() {
    return yamlConfig;
  }

  public List<String> getServers() {
    return this.servers;
  }

  public void setYamlConfig(YamlConfig yamlConfig) {
    this.yamlConfig = yamlConfig;
  }

  public void setRandom(String random) {
    this.random = random;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setName3(String name3) {
    this.name3 = name3;
  }

  public void setName4(String name4) {
    this.name4 = name4;
  }

  @GetMapping("")
  public String getConfigPara() {
    return getName() + " " + getName2() + " " + getName3() + " " + getName4();
  }

  @GetMapping("/random")
  public String getConfigParaRandom() {
    return getRandom();
  }

  @GetMapping("/yaml")
  public List<String> getYamlVal() {
    return yamlConfig.getServers();
  }

  @GetMapping("/properties")
  public List<String> getPropertiesVal() {
    return getServers();
  }

  @GetMapping("1")
  public String getString() {
    return getTestConfig().getString();
  }
}
