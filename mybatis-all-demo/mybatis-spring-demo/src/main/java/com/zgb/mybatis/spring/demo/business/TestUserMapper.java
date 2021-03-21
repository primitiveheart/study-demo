package com.zgb.mybatis.spring.demo.business;

import com.zgb.mybatis.spring.demo.business.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/4 11:40 下午
 * @Created By guanbao.zhou
 */
public class TestUserMapper {
  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("application-jdbc-context.xml");
    UserMapper userMapper = ac.getBean(UserMapper.class);

  }
}
