package com.zgb.mybatis.demo;

import com.zgb.mybatis.demo.page.UserQuery;

import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 8:24 上午
 * @Created By guanbao.zhou
 */
public interface UserMapper {
  UserDO selectUser(Integer id);

  void updateUserById(UserDO userDO);

  List<UserDO> listByConditions(UserQuery userQuery);
}
