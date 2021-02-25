package com.zgb.spring.boot.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/24 3:52 下午
 * @Created By guanbao.zhou
 */
public class MyImportSelector implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{"com.zgb.spring.boot.demo.controller.UserController"};
  }
}
