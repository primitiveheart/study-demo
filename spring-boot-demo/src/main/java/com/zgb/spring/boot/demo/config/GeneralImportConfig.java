package com.zgb.spring.boot.demo.config;

import com.zgb.spring.boot.demo.controller.TestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/2/24 1:35 下午
 * @Created By guanbao.zhou
 */
//@Import({TestController.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Import({MyImportBeanDefinitionRegistrar.class})
//@Import({TestController.class})
//@Import({MyImportSelector.class})
public class GeneralImportConfig {
}
