package com.zgb.mybatis.demo.plugin;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 7:00 下午
 * @Created By guanbao.zhou
 */
public class UserQuery extends PageQuery {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
