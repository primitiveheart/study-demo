package com.zgb.spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 1:36 下午
 * @Created By guanbao.zhou
 */
@Controller
@RequestMapping("/api")
public class AnnotationController {

  @RequestMapping("/annotation")
  @ResponseBody
  public String annotation(String name) {
    System.out.println("Controller annotation Controller");
    return "annotation";
  }
}
