package com.zgb.demo.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 9:18 上午
 * @Created By guanbao.zhou
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
