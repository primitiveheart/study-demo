package com.zgb.mybatis.spring.boot.demo.mapper;

import com.zgb.mybatis.spring.boot.demo.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM users WHERE id = #{id}")
  UserDO getUser(@Param("id") int userId);
}