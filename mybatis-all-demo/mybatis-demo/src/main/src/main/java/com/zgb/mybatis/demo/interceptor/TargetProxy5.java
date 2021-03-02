package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 2:40 下午
 * @Created By guanbao.zhou
 */
public class TargetProxy5 implements InvocationHandler {
  private Object target;
  //拦截器
  private Interceptor4 interceptor;

  private TargetProxy5(Object target, Interceptor4 interceptor) {
    this.target = target;
    this.interceptor = interceptor;
  }

  /**
   * 通过传入客户端封装好 interceptor 的方式为 target 生成代理对象，使得客户端可以灵活使用不同的拦截器逻辑
   * @param target
   * @param interceptor
   * @return
   */
  public static Object bind(Object target, Interceptor4 interceptor) {
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new TargetProxy5(target, interceptor));
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
    if (Objects.isNull(methodName)){
      throw new NullPointerException("interceptor annotation MethodName not can null!");
    }
    //如果方法名称和注解标记的方法名称相同，则拦截
    String name = methodName.value();
    if (name.equals(method.getName())){
      return interceptor.intercept(new Invocation(target,    method, args));
    }
    return method.invoke(this.target, args);
  }
}
