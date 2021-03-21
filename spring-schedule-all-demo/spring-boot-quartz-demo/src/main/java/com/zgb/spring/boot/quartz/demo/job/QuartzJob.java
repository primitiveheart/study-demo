package com.zgb.spring.boot.quartz.demo.job;

import lombok.SneakyThrows;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 9:11 上午
 * @Created By guanbao.zhou
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {
  @SneakyThrows
  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println(jobExecutionContext.getScheduler().getSchedulerInstanceId());
    System.out.println("taskName = " + jobExecutionContext.getJobDetail());
  }
}
