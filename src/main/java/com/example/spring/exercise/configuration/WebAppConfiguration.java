package com.example.spring.exercise.configuration;

import com.example.spring.exercise.interceptor.LogInterceptor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Data
public class WebAppConfiguration implements WebMvcConfigurer {

  @Bean
  public LogInterceptor getLogInterceptor() {
    return new LogInterceptor();
  }

  /**
   * 添加拦截器.
   *
   * @param registry .
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加登录处理拦截器，拦截所有请求，登录请求除外
    InterceptorRegistration interceptorRegistration = registry.addInterceptor(getLogInterceptor());
    // 配置拦截策略
    interceptorRegistration.addPathPatterns("/**");
    // 值越小，拦截器越靠前。
    interceptorRegistration.order(-90000);
  }
}
