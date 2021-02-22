package com.zgb.test.demo.controller;

import com.zgb.test.demo.pojo.vo.UserVO;
import com.zgb.test.demo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/22 8:23 下午
 * @Created By guanbao.zhou
 */
@WebMvcTest
class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private UserService userService;

  @Test
  void getUserById() throws Exception {
    UserVO user = new UserVO();
    user.setId(1);
    user.setName("zhou");

    // stub-打桩
    Mockito.when(userService.getUserById(1)).thenReturn(user);

    // 模拟http请求
    //  MockMvcRequestBuilders.get("/user", 1)
    mvc.perform(get("/user?id=1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("zhou")));

  }
}