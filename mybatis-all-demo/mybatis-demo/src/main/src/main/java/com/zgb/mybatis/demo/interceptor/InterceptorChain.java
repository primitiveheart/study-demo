package com.zgb.mybatis.demo.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterceptorChain {

  private final List<InterceptorFinal> interceptors = new ArrayList<InterceptorFinal>();

  public Object pluginAll(Object target) {
    for (InterceptorFinal interceptor : interceptors) {
      // 该方法和我们上面自定义拦截器中 register 方法功能一致
      target = interceptor.register(target);
    }
    return target;
  }

  public void addInterceptor(InterceptorFinal interceptor) {
    interceptors.add(interceptor);
  }
  
  public List<InterceptorFinal> getInterceptors() {
    return Collections.unmodifiableList(interceptors);
  }

}