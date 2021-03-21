package com.zgb.spring.mvc.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/8 7:44 下午
 * @Created By guanbao.zhou
 * <mvc:interceptors>
 *   <mvc:interceptor>
 *     指定拦截地址
 *     <mvc:mapping path="/api"></mvc:mapping>
 *     生命拦截器的信息
 *     <bean></bean>
 *   </mvc:interceptor>
 * </mvc:interceptors>
 */
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("LoginInterceptor preHandle :  " + handler.toString());
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("LoginInterceptor postHandle :  " + handler.toString());
  }
}
