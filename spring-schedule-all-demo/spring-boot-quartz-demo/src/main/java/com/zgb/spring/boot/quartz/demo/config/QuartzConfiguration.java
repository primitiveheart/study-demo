package com.zgb.spring.boot.quartz.demo.config;

import com.zgb.spring.boot.quartz.demo.task.CustomJobFactory;
import com.zgb.spring.boot.quartz.demo.task.JobDemo;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/9 9:22 上午
 * @Created By guanbao.zhou
 */
@Configuration
public class QuartzConfiguration {
  /**
   * 创建Job对象。在Spring环境中，创建一个类型的对象的时候，很多情况下，
   * 都是通过FactoryBean来间接创建的。如果有多个Job对象，定义多次方法。
   * <p>
   * 在JobDetailFactoryBean类型中，用于创建JobDetail对象的方法，
   * 其底层使用的逻辑是：Class.newInstance()也就是说，JobDetail对象不是通过Spring容器管理的。
   * 因为Spring容器不管理JobDetail对象，那么Job中需要自动装配的属性，就无法实现自动状态。
   * 如上JOB的第10行会报空指针异常。
   * <p>
   * 解决方案是： 将JobDetail加入到Spring容器中，让Spring容器管理JobDetail对象。
   * 需要重写Factory相关代码。实现Spring容器管理JobDetail。
   *
   * @return
   */
  @Bean
  public JobDetailFactoryBean initJobDetailFactoryBean() {
    JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
    // 提供job类型。
    factoryBean.setJobClass(JobDemo.class);
    return factoryBean;
  }

  /**
   * 触发器
   * 管理Trigger对象
   * CronTrigger - 就是Trigger的一个实现类型。 其中用于定义周期时间的是CronSchedulerBuilder
   * 实际上，CronTrigger是用于管理一个Cron表达式的类型。
   *
   * @return
   */
  @Bean
  public CronTriggerFactoryBean initCronTriggerFactoryBean() {
    CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
    JobDetailFactoryBean jobDetailFactoryBean = this.initJobDetailFactoryBean();
    factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
    factoryBean.setCronExpression("0/3 * * * * ?");
    return factoryBean;
  }

//  /**
//   * 调度器
//   * 初始化Scheduler
//   *
//   * @param customJobFactory
//   * @param cronTriggerFactoryBean
//   * @return
//   */
//  @Bean
//  public SchedulerFactoryBean initSchedulerFactoryBean(CustomJobFactory customJobFactory,
//                                                       CronTriggerFactoryBean[] cronTriggerFactoryBean) {
//    SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
//    CronTrigger[] triggers = new CronTrigger[cronTriggerFactoryBean.length];
//    for (int i = 0; i < cronTriggerFactoryBean.length; i++) {
//      triggers[i] = cronTriggerFactoryBean[i].getObject();
//    }
//    // 注册触发器，一个Scheduler可以注册若干触发器。
//    factoryBean.setTriggers(triggers);
//    // 为Scheduler设置JobDetail的工厂。可以覆盖掉SpringBoot提供的默认工厂，保证JobDetail中的自动装配有效。
//    factoryBean.setJobFactory(customJobFactory);
//
//    return factoryBean;
//  }


  @Bean
  public Scheduler scheduler(DataSource dataSource) throws IOException {
    return schedulerFactoryBean(dataSource).getScheduler();
  }

  @Bean
  public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) throws IOException {
    SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
    factoryBean.setSchedulerName("cluster_scheduler");
    factoryBean.setDataSource(dataSource);
    factoryBean.setApplicationContextSchedulerContextKey("application");
    factoryBean.setQuartzProperties(quartzProperties());
    factoryBean.setTaskExecutor(scheduledThreadPool());
    factoryBean.setStartupDelay(0);
    return factoryBean;

  }

  @Bean
  public Properties quartzProperties() throws IOException {
    PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
    factoryBean.setLocation(new ClassPathResource("/spring-quartz.properties"));
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean
  public Executor scheduledThreadPool() {
    ThreadPoolTaskExecutor executor  = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
    executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
    executor.setQueueCapacity(Runtime.getRuntime().availableProcessors());
    return executor;
  }
}
