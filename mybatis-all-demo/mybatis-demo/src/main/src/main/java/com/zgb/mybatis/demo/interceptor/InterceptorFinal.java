package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 2:45 下午
 * @Created By guanbao.zhou
 */
public interface InterceptorFinal {
  public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

  public Object register(Object target);
}
