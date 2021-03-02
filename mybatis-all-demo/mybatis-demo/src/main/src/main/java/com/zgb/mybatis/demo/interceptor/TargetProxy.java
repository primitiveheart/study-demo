
package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象
 */
public class TargetProxy implements InvocationHandler {
  private Object target;

  private TargetProxy(Object target) {
    this.target = target;
  }

  /**
   * 代理对象生成目标对象
   *
   * @param target
   * @return
   */
  public static Object bind(Object target) {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new TargetProxy(target));
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    System.out.println("Begin");
    return method.invoke(target, args);
  }
}