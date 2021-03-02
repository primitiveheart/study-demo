package com.zgb.mybatis.demo.interceptor;

public class TargetImpl implements Target {
  public void execute() {
    System.out.println("Execute");
  }

  @Override
  public void execute1() {
    System.out.println("execute1");
  }
}