package com.zgb.test.demo.service;

import com.zgb.test.demo.pojo.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/23 12:47 上午
 * @Created By guanbao.zhou
 */
@SpringBootTest
public class UserServiceIntegrationTest {

  @Autowired
  private UserService userService;

  @Test
  public void test() {
    UserVO us = userService.getUserById(1);
    Assertions.assertThat(us).isNotNull();
  }
}
