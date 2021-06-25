package com.example.spring.exercise.controller;

import com.example.spring.exercise.controller.rsp.BaseRsp;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试httpsession.
 *
 * @author gaoyang
 * @since 2021-6-24
 */
@RestController
@RequestMapping("/TestHttpSession")
public class HttpSessionController {

  @GetMapping("/test1")
  public BaseRsp<Void> test1(HttpSession httpSession){
    System.out.println("test1:"+httpSession.getId());
    return BaseRsp.success();
  }

  @GetMapping("/test2")
  public BaseRsp<Void>  test2(HttpSession httpSession){
    System.out.println("test2:"+httpSession.getId());
    return BaseRsp.success();
  }
}
