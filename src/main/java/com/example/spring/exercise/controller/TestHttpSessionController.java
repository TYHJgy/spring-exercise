package com.example.spring.exercise.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试httpsession.
 *
 * @author gaoyang
 * @since 2021-6-24
 */
@Controller
@RequestMapping("/TestHttpSession")
public class TestHttpSessionController {

  @GetMapping("test1")
  public void test1(HttpSession httpSession){
    System.out.println("test1:"+httpSession.getId());
  }

  @GetMapping("test2")
  public void test2(HttpSession httpSession){
    System.out.println("test2:"+httpSession.getId());
  }
}
