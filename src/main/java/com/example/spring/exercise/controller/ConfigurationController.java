package com.example.spring.exercise.controller;

import com.example.spring.exercise.configuration.TestConfiguration;
import com.example.spring.exercise.configuration.YamlConfig;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置信息测试类.
 *
 * @author gy
 * @since 2021-5-26 14:53:16 *
 */
@RestController
@RequestMapping("/config")
@ConfigurationProperties(prefix = "my.config") // 前缀为"my.config"的配置。
@Data
public class ConfigurationController {

  /** 配置在"application.properties"中 name=gy，前缀不是"my.config"，结果为null. */
  private String name;

  /** 配置在"application.properties"中 name2=gy2，前缀不是"my.config"，需要添加注解 @Value("${name}"). */
  @Value("${name}")
  private String name2;

  /** 配置在@Value("gaoyang") my.config.name3=gy3. */
  @Value("gaoyang")
  private String name3;

  /** 配置在@Value("gy4"). */
  @Value("gy4")
  private String name4;

  /** 配置在application.properties中 my.config.random=${random.int}. */
  private String random;

  private List<String> servers = new ArrayList<>();

  @Resource private YamlConfig yamlConfig; // 配置文件"application.yml"的配置操作

  @Resource private TestConfiguration testConfig;

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
