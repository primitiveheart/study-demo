package com.zgb.mybatis.spring.boot.demo.mapper;

import com.zgb.mybatis.spring.boot.demo.entity.UserDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 8:54 上午
 * @Created By guanbao.zhou
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

  @Autowired
  UserMapper userMapper;

  @Test
  void getUser() {
    UserDO user = userMapper.getUser(1);
    Assertions.assertThat(user).isNotNull();

  }
}