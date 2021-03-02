package com.zgb.mybatis.demo.interceptor;

public class Client {
  public static void main(String[] args) {
    Target target = new TargetImpl();
    Interceptor4 interceptor = new InterceptorImpl();
    target = (Target)TargetProxy5.bind(target, interceptor);
    target.execute1();
  }

  private static void version2() {
    //客户端可以在此处定义多种拦截逻辑
    Interceptor interceptor = new Interceptor() {
      @Override
      public void intercept() {
        System.out.println("Go Go Go!!!");
      }
    };
    Target target = new TargetImpl();
    target = (Target) TargetProxy2.bind(target, interceptor);
    target.execute();
    // 执行结果:
    // Go Go Go!!!
    // Execute
  }

  private static void version1() {
    //没被代理之前
    Target target = new TargetImpl();
    target.execute();
    //执行结果：
    //Execute

    //被代理之后
    target = (Target) TargetProxy.bind(target);
    target.execute();
    //执行结果：
    //Begin
    //Execute
  }
}