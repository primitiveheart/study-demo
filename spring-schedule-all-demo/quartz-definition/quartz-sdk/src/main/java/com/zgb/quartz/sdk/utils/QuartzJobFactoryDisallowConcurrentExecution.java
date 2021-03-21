package com.zgb.quartz.sdk.utils;

import com.zgb.quartz.common.pojo.entity.ScheduleJob;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author wison
 * @Description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * @date 2017年11月11日 下午5:05:47
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
  public final Logger log = LoggerFactory.getLogger(this.getClass());

  public void execute(JobExecutionContext context) throws JobExecutionException {
    ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
    TaskUtils.invokMethod(scheduleJob);

  }
}