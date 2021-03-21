package com.zgb.mybatis.demo.page;

import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 7:00 下午
 * @Created By guanbao.zhou
 */
public class UserQuery extends PageQuery {
  private List<Integer> ids;
  private String name;

  public List<Integer> getIds() {
    return ids;
  }

  public void setIds(List<Integer> ids) {
    this.ids = ids;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
