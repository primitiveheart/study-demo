package com.zgb.test.demo.dao;

import com.zgb.test.demo.pojo.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 10:05 下午
 * @Created By guanbao.zhou
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
class UserMapperTest {

  @SpringBootApplication(scanBasePackages = "com.zgb.test.demo.dao")
  static class InnerConfig{};

  @Autowired
  private UserMapper userMapper;

  @Test
  void getUserById() {
    UserDO userDO = userMapper.getUserById(1);
    Assertions.assertThat(userDO.getName()).isEqualTo("zhou");
  }
}