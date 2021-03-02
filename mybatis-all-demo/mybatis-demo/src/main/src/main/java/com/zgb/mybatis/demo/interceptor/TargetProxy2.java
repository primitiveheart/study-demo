package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 2:40 下午
 * @Created By guanbao.zhou
 */
public class TargetProxy2 implements InvocationHandler {
  private Object target;
  //拦截器
  private Interceptor interceptor;

  private TargetProxy2(Object target, Interceptor interceptor) {
    this.target = target;
    this.interceptor = interceptor;
  }

  /**
   * 通过传入客户端封装好 interceptor 的方式为 target 生成代理对象，使得客户端可以灵活使用不同的拦截器逻辑
   * @param target
   * @param interceptor
   * @return
   */
  public static Object bind(Object target, Interceptor interceptor) {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new TargetProxy2(target, interceptor));
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    //客户端实现自定义的拦截逻辑
    interceptor.intercept();
    return method.invoke(target, args);
  }
}
