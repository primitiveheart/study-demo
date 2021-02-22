package com.zgb.test.demo.dao;

import com.zgb.test.demo.pojo.entity.UserDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/23 12:16 上午
 * @Created By guanbao.zhou
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperRealDBTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  void getUserById() {
    UserDO userDO = userMapper.getUserById(1);
    Assertions.assertThat(userDO.getName()).isEqualTo("zhou");
  }
}
