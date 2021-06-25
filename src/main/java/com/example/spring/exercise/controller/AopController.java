package com.example.spring.exercise.controller;

import com.example.spring.exercise.service.AopByAnnotationService;
import com.example.spring.exercise.service.AopByMethodService;
import com.example.spring.exercise.controller.rsp.BaseRsp;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testAop")
public class AopController {

  @Resource
  private AopByAnnotationService aopByAnnotationService;
  @Resource
  private AopByMethodService aopByMethodService;

  @GetMapping("")
  public BaseRsp<Void> testAop() {
    System.out.println("\nenter AopController.testAop()");
    // 基于注解的拦截.
    aopByAnnotationService.add();

    // 基于方法规则的拦截.
    aopByMethodService.add();

    System.out.println("leave AopController.testAop()\n");
    return BaseRsp.success();
  }
}
