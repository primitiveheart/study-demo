package com.zgb.spring.boot.demo.config;

import com.zgb.spring.boot.demo.controller.ApiController;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/24 3:57 下午
 * @Created By guanbao.zhou
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
    RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ApiController.class);
    beanDefinitionRegistry.registerBeanDefinition("apiController", rootBeanDefinition);
  }
}
