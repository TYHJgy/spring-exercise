package com.example.spring.exercise.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 日志拦截器.
 *
 * <p>拦截器需要实现HandlerInterceptor接口</p>
 * <p>拦截器需要实现HandlerInterceptor接口</p>
 * <p>负责初始化日志，记录请求BODY，响应BODY</p>
 */
public class LogInterceptor implements HandlerInterceptor {

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView arg3) {
    System.out.println("this is postHandle");
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    System.out.println("this is preHandle");
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    System.out.println("this is afterCompletion");
  }



}


