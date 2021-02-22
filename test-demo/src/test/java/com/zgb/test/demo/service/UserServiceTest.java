package com.zgb.test.demo.service;

import com.zgb.test.demo.dao.UserMapper;
import com.zgb.test.demo.pojo.entity.UserDO;
import com.zgb.test.demo.pojo.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 8:17 下午
 * @Created By guanbao.zhou
 */
@SpringBootTest
class UserServiceTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserMapper userMapper;

  @Test
  void getUserById() {
    UserDO user = new UserDO();
    user.setId(1);
    user.setName("zhou");

    // 打桩
    Mockito.when(userMapper.getUserById(1)).thenReturn(user);

    // 断言
    UserVO result = userService.getUserById(1);
    Assertions.assertThat(result.getName()).isEqualTo("zhou");

  }
}