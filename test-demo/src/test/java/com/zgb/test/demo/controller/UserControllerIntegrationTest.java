package com.zgb.test.demo.controller;

import org.h2.engine.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/23 12:33 上午
 * @Created By guanbao.zhou
 */
@SpringBootTest
public class UserControllerIntegrationTest {
  @Autowired
  private UserController userController;

  @Autowired
  private WebApplicationContext wac;

  MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    // 单个Controller
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
    // 整个应用程序
//    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testSync() throws Exception {
    mockMvc.perform(get("/user?id=1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("zhou")));
  }

  @Test
  public void testAsync() throws Exception {
    MvcResult result = mockMvc.perform(get("/manga/async/ken"))
            .andDo(print())
            .andExpect(request().asyncStarted())
            .andDo(print())
            .andReturn();

    mockMvc.perform(asyncDispatch(result))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("zhou")));
  }

}
