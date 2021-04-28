package com.zgb.spring.boot.quartz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EnableScheduling 必要开启定时任务机制。
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootQuartzDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootQuartzDemoApplication.class, args);
  }

}
