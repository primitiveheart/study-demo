package com.zgb.spring.mvc.demo.config;

import com.zgb.spring.mvc.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 1:34 下午
 * @Created By guanbao.zhou
 * 配置mvc几种方式：默认Spring-mvc有默认配置
 * 第一种方式：继承WebMvcConfigurationSupport
 * 第二种方式：@EnableWebMvc 和 WebMvcConfigurer搭配
 */
@Configuration
@ComponentScan(basePackages = "com.zgb.spring.mvc.demo")
public class AppConfig extends WebMvcConfigurationSupport {

  /**
   * 添加类型转换
   *
   * @param registry
   */
  @Override
  public void addFormatters(FormatterRegistry registry) {

  }


  /**
   * 添加拦截器
   *
   * @param registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    /**
     * xml中配置
     *    * <mvc:interceptors>
     *    *     <bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"/>
     *    *     <mvc:interceptor>
     *    *         <mvc:mapping path="/**"/>
     *    *         <mvc:exclude-mapping path="/admin/**"/>
     *    *         <bean class="org.springframework.web.servlet.theme.ThemeChangeInterceptor"/>
     *    *     </mvc:interceptor>
     *    *     <mvc:interceptor>
     *    *         <mvc:mapping path="/secure/*"/>
     *    *         <bean class="org.example.SecurityInterceptor"/>
     *    *     </mvc:interceptor>
     *    * </mvc:interceptors>
     */
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**");
  }

  /**
   * 添加参数解析器
   *
   * @param resolvers
   */
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

  }

  /**
   * 添加结果解析器
   *
   * @param handlers
   */
  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

  }

  /**
   * 视图解析器
   *
   * @param registry
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {

  }

  /**
   * 消息转换器
   *
   * @param converters
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    /**
     *<mvc:annotation-driven>
     *     <mvc:message-converters>
     *         <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
     *             <property name="objectMapper" ref="objectMapper"/>
     *         </bean>
     *         <bean class="org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter">
     *             <property name="objectMapper" ref="xmlMapper"/>
     *         </bean>
     *     </mvc:message-converters>
     * </mvc:annotation-driven>
     *
     * <bean id="objectMapper" class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean"
     *       p:indentOutput="true"
     *       p:simpleDateFormat="yyyy-MM-dd"
     *       p:modulesToInstall="com.fasterxml.jackson.module.paramnames.ParameterNamesModule"/>
     *
     * <bean id="xmlMapper" parent="objectMapper" p:createXmlMapper="true"/>
     */
  }
}
