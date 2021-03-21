package com.zgb.spring.boot.quartz.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 9:06 下午
 * @Created By guanbao.zhou
 */
public class Job2Listener implements JobListener {
  @Override
  public String getName() {
    return "job";
  }

  @Override
  public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
    System.out.println("jobToBeExecuted");
  }

  @Override
  public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
    System.out.println("jobExecutionVetoed");
  }

  @Override
  public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
    System.out.println("jobWasExecuted");
  }
}
