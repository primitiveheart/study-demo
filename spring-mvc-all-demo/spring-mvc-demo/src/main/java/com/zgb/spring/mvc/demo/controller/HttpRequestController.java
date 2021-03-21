package com.zgb.spring.mvc.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 1:38 下午
 * @Created By guanbao.zhou
 */
@Component("/api/http/request")
public class HttpRequestController implements HttpRequestHandler {
  @Override
  public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Controller extends http request");
  }
}
