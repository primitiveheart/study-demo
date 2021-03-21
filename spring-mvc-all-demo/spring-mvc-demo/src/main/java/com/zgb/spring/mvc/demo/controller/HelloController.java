package com.zgb.spring.mvc.demo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/8 7:35 下午
 * @Created By guanbao.zhou
 */
public class HelloController implements Controller {
  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("success");
    modelAndView.addObject("hello", "测试");
    return modelAndView;
  }
}
