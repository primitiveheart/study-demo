package com.zgb.mybatis.spring.demo.business.mapper;

import com.zgb.mybatis.spring.demo.business.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/28 11:27 上午
 * @Created By guanbao.zhou
 */
public interface UserMapper {
  @Select("SELECT * FROM users WHERE id = #{id}")
  UserDO getUser(@Param("id") String userId);
}
