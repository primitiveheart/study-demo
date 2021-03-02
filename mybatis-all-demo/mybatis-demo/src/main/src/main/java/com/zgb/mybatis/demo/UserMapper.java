package com.zgb.mybatis.demo;


/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/2 8:24 上午
 * @Created By guanbao.zhou
 */
public interface UserMapper {
    UserDO selectUser(Integer id);

    void updateUserById(UserDO userDO);
}
