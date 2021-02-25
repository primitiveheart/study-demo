package com.zgb.spring.boot.demo.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 12:48 上午
 * @Created By guanbao.zhou
 */
@SpringBootTest
class EnableConfigurationPropertiesDemoTest {

  @Autowired
  private ConfigurationPropertiesDemo configurationPropertiesDemo;
  @Test
  public void test() {
    Assertions.assertThat(configurationPropertiesDemo.getName()).startsWith("test");
  }
}