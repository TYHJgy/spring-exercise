package com.example.spring.exercise;

import com.example.spring.exercise.configuration.WebAppConfiguration;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ImportAutoConfiguration({WebAppConfiguration.class})
public class ExerciseApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(ExerciseApplication.class);
    /** OFF G关闭 CLOSED 后台控制台输出，默认就是这种 LOG 日志输出 */
    application.setBannerMode(Banner.Mode.CONSOLE);
    application.run(args);
  }
  /*应用程序退出时（执行SpringApplication.exit()）会调用该方法*/
  @Bean
  public ExitCodeGenerator exitCodeGenerator() {
    return () -> 42;
  }
}
