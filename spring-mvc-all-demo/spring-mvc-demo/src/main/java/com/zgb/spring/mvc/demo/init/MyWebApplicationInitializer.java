package com.zgb.spring.mvc.demo.init;

import com.zgb.spring.mvc.demo.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/5 1:24 下午
 * @Created By guanbao.zhou
 */
//实现java config 第一步，实现Spring 接口
public class MyWebApplicationInitializer implements WebApplicationInitializer {


  // 如何让自己写的代码让tomcat调用
  // WebApplicationInitializer是Spring的接口
  // Servlet 3.0 版本以后是提出一个新规范 SPI
  // 第一步："你"的项目里面如果有某些类或方法，需要在启动的时候，被tomcat(web容器)调用的话
  // 第二步：在的你项目的根目录 META-INF/services 目录下写一个文件

  // Spring-web
  // Spring SpringServletContainerInitializer接口实现Servlet ServletContainerInitializer 接口
  // @HandlesTypes(WebApplicationInitializer.class)
  //public class SpringServletContainerInitializer implements ServletContainerInitializer

  // Spring + Spring MVC 搭建一个伪Spring boot

  // 为什么web容器会调用onStartUp
  // web容器会在启动的时候去调用onStartup()
  // ServletContext web上下文对象
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    // ContextLoaderListener 在web xml配置加载spring 容器
    // Load Spring web application configuration
    // 加载
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.setServletContext(servletContext);
    ac.refresh();


    // DispatcherServlet 注入的几种方式
    // 1。@WebServlet 注解注入Servlet
    // 2。web.xml
    // 3。ServletContext
    // Create and register the DispatcherServlet
    DispatcherServlet servlet = new DispatcherServlet(ac);
    ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/*");

  }
}
