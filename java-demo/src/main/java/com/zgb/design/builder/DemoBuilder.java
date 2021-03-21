package com.zgb.design.builder;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/4 9:59 上午
 * @Created By guanbao.zhou
 */
public class DemoBuilder {
  private String name;
  private Integer age;
  private String desc;
  private String tel;

  public DemoBuilder(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public static DemoBuilder builder(String name, Integer age){
    return new DemoBuilder(name, age);
  }

  public DemoBuilder desc(String desc) {
    this.desc =  desc;
    return this;
  }

  public DemoBuilder tel(String tel) {
    this.desc = desc;
    return this;
  }

  public DemoBuilder build() {
    // 一般做一些检查的操作
   return this;
  }
}
