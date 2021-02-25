package com.zgb.demo.spring.boot.autoconfigure;

import com.zgb.demo.DemoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/25 9:15 上午
 * @Created By guanbao.zhou
 */
@Configuration
@ConditionalOnClass({DemoService.class})
@EnableConfigurationProperties({DemoProperties.class})
public class DemoAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public DemoService getDemoService(DemoProperties demoProperties) {
    DemoService demoService = new DemoService();
    demoService.setName(demoProperties.getName());
    return demoService;
  }
}
