package com.zgb.spring.boot.quartz.demo.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/9 9:21 上午
 * @Created By guanbao.zhou
 */
public class JobDemo implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("Job Demo : " + new Date());
  }
}
