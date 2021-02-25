package com.zgb.test.demo;

import com.zgb.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 9:45 上午
 * @Created By guanbao.zhou
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TestAutoConfiguration {

  @Autowired
  private MockMvc mockMvc;


  @Test
  public void test() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/demo"))
            .andDo(print())
            .andExpect(status().isOk());
  }
}
