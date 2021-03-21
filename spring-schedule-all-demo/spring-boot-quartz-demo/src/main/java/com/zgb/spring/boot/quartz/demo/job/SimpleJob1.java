package com.zgb.spring.boot.quartz.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.util.Date;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 9:03 下午
 * @Created By guanbao.zhou
 */
public class SimpleJob1 implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    JobKey key = jobExecutionContext.getJobDetail().getKey();
    System.out.println("SimpleJob1 " + key + " executing at " + new Date());
  }
}
