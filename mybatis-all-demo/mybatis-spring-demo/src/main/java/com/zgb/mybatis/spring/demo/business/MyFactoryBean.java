package com.zgb.mybatis.spring.demo.business;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/4 10:33 上午
 * @Created By guanbao.zhou
 */
@Component
public class MyFactoryBean implements FactoryBean {

  @Override
  public Object getObject() throws Exception {
    return null;
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }
}
