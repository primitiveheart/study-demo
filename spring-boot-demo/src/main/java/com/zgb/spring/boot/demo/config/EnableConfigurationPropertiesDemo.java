package com.zgb.spring.boot.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 12:47 上午
 * @Created By guanbao.zhou
 */
@Component
@EnableConfigurationProperties(value = ConfigurationPropertiesDemo.class)
public class EnableConfigurationPropertiesDemo {
}
