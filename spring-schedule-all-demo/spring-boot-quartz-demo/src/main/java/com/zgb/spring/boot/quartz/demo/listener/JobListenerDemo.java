package com.zgb.spring.boot.quartz.demo.listener;

import com.zgb.spring.boot.quartz.demo.job.SimpleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Matcher;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/3/16 9:08 下午
 * @Created By guanbao.zhou
 */
public class JobListenerDemo {
  public static void main(String[] args) throws SchedulerException {
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

    JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
            .withIdentity("job1").build();

    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1").startNow().build();

    // 建立监听器
    Job2Listener job2Listener = new Job2Listener();
    Matcher<JobKey> matcher = KeyMatcher.keyEquals(jobDetail.getKey());
    scheduler.getListenerManager().addJobListener(job2Listener, matcher);

    scheduler.scheduleJob(jobDetail, trigger);
    scheduler.start();
  }
}
