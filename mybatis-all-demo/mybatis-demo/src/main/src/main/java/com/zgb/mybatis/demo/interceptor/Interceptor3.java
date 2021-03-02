package com.zgb.mybatis.demo.interceptor;

import java.lang.reflect.Method;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 2:45 下午
 * @Created By guanbao.zhou
 */
public interface Interceptor3 {
  public void intercept(Method method, Object[] args);
}
