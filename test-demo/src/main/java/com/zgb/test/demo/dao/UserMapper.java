package com.zgb.test.demo.dao;

import com.zgb.test.demo.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 8:08 下午
 * @Created By guanbao.zhou
 */
@Mapper
public interface UserMapper {

  @Select("select * from user where id = #{id}")
  UserDO getUserById(@Param("id") Integer id);

  void save(UserDO userDO);
}
