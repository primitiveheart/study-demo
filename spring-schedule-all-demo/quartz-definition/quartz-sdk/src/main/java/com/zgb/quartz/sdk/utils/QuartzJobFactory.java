package com.zgb.quartz.sdk.utils;

import com.zgb.quartz.common.pojo.entity.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wison
 * @Description: 计划任务执行处 无状态
 * @date 2017年11月11日 下午5:05:47
 */
public class QuartzJobFactory implements Job {
  public final Logger log = LoggerFactory.getLogger(this.getClass());

  public void execute(JobExecutionContext context) throws JobExecutionException {
    ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
    TaskUtils.invokMethod(scheduleJob);
  }
}