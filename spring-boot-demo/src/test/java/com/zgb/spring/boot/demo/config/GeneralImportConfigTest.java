package com.zgb.spring.boot.demo.config;

import com.zgb.spring.boot.demo.controller.ApiController;
import com.zgb.spring.boot.demo.controller.TestController;
import com.zgb.spring.boot.demo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/24 1:35 下午
 * @Created By guanbao.zhou
 */
class GeneralImportConfigTest {

  @Test
  public void testGeneral () {
    ApplicationContext ac = new AnnotationConfigApplicationContext(GeneralImportConfig.class);
    TestController testController = ac.getBean(TestController.class);
    assertThat(testController, instanceOf(TestController.class));
  }

  @Test
  public void testImportConfig() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(GeneralImportConfig.class);
    UserController userController = ac.getBean(UserController.class);
    assertThat(userController, instanceOf(UserController.class));
  }

  @Test void testImportRegistrarConfig() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(GeneralImportConfig.class);
    ApiController apiController = ac.getBean(ApiController.class);
    assertThat(apiController, instanceOf(ApiController.class));
  }
}