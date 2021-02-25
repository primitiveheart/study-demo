package com.zgb.demo;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 9:03 上午
 * @Created By guanbao.zhou
 */
public class DemoService {
  private String name;


  public void setName(String name) {
    this.name = name;
  }

  public void say() {
    System.out.println("hello demo " + name);
  }
}
