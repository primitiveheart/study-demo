package com.zgb.spring.boot.quartz.demo.init;

import com.zgb.spring.boot.quartz.demo.job.QuartzJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 9:08 上午
 * @Created By guanbao.zhou
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
  @Autowired
  private Scheduler scheduler;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group");
    try {
      Trigger trigger = scheduler.getTrigger(triggerKey);
      if (trigger == null) {
        trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * *  ?"))
                .build();

        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("job1", "group1")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
      }
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }
}
