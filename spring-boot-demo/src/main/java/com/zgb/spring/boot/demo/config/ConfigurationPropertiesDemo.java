package com.zgb.spring.boot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 12:44 上午
 * @Created By guanbao.zhou
 */
@Data
@ConfigurationProperties(prefix = "configuration.properties")
public class ConfigurationPropertiesDemo {
  private String name;
}
