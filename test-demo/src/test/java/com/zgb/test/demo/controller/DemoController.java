package com.zgb.test.demo.controller;

import com.zgb.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 10:14 上午
 * @Created By guanbao.zhou
 */
@RestController
public class DemoController {
  @Autowired
  private DemoService demoService;

  @RequestMapping("/demo")
  public String demo() {
    demoService.say();
    return "success";
  }
}
