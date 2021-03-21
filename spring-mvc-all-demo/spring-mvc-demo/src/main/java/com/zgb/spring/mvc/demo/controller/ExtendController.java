package com.zgb.spring.mvc.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 1:37 下午
 * @Created By guanbao.zhou
 */
@Component("/api/extend")
public class ExtendController implements Controller {
  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("Controller implements controller!");
    return null;
  }
}
