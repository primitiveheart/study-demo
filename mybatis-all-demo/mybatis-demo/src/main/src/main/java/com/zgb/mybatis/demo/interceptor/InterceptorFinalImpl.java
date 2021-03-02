package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 3:03 下午
 * @Created By guanbao.zhou
 */
@MethodName("execute1")
public class InterceptorFinalImpl implements InterceptorFinal {
  @Override
  public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
    System.out.println("interceptor");
    return invocation.proceed();
  }

  @Override
  public Object register(Object target) {
    return TargetProxyFinal.bind(target, this);
  }
}
