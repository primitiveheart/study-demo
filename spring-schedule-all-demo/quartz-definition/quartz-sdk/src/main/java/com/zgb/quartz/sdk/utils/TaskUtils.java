package com.zgb.quartz.sdk.utils;

import com.zgb.quartz.common.pojo.entity.ScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class TaskUtils {

  public final static Logger log = LoggerFactory.getLogger(this.getClass());

  /**
   * 通过反射调用scheduleJob中定义的方法
   *
   * @param scheduleJob
   */
  @SuppressWarnings("unchecked")
  public static void invokMethod(ScheduleJob scheduleJob) {
    Object object = null;
    Class clazz = null;
    boolean flag = true;
    if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
      object = SpringUtils.getBean(scheduleJob.getSpringId());
    } else if (StringUtils.isNotBlank(scheduleJob.getBeanClass())) {
      try {
        clazz = Class.forName(scheduleJob.getBeanClass());
        object = clazz.newInstance();
      } catch (Exception e) {
        flag = false;
        STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
                STimetaskLogService.class);
        STimetaskLog tlog = new STimetaskLog();
        tlog.setId(UUIDUtil.getUUID());
        tlog.setCreateDate(new Date());
        tlog.setJobId(scheduleJob.getJobId().toString());
        tlog.setReason("未找到" + scheduleJob.getBeanClass() + "对应的class");
        tlog.setState("fail");
        sTimetaskLogService.insertSelective(tlog);
        e.printStackTrace();
      }

    }
    if (object == null) {
      flag = false;
      log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
      STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
              STimetaskLogService.class);
      STimetaskLog tlog = new STimetaskLog();
      tlog.setId(UUIDUtil.getUUID());
      tlog.setCreateDate(new Date());
      tlog.setJobId(scheduleJob.getJobId().toString());
      tlog.setReason("未找到" + scheduleJob.getBeanClass() + "对应的class");
      tlog.setState("fail");
      sTimetaskLogService.insertSelective(tlog);
      return;
    }
    clazz = object.getClass();
    Method method = null;
    try {
      method = clazz.getDeclaredMethod(scheduleJob.getMethodName(), new Class[]{String.class});
    } catch (NoSuchMethodException e) {
      flag = false;
      log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，方法名设置错误！！！");
      STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
              STimetaskLogService.class);
      STimetaskLog tlog = new STimetaskLog();
      tlog.setId(UUIDUtil.getUUID());
      tlog.setCreateDate(new Date());
      tlog.setJobId(scheduleJob.getJobId().toString());
      tlog.setReason("未找到" + scheduleJob.getBeanClass() + "类下" + scheduleJob.getMethodName() + "对应的方法");
      tlog.setState("fail");
      sTimetaskLogService.insertSelective(tlog);
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (method != null) {
      try {
        method.invoke(object, scheduleJob.getJobData());
      } catch (IllegalAccessException e) {
        flag = false;
        STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
                STimetaskLogService.class);
        STimetaskLog tlog = new STimetaskLog();
        tlog.setId(UUIDUtil.getUUID());
        tlog.setCreateDate(new Date());
        tlog.setJobId(scheduleJob.getJobId().toString());
        tlog.setReason("未找到" + scheduleJob.getBeanClass() + "类下" + scheduleJob.getMethodName() + "对应的方法参数设置错误");
        tlog.setState("fail");
        sTimetaskLogService.insertSelective(tlog);
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        flag = false;
        STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
                STimetaskLogService.class);
        STimetaskLog tlog = new STimetaskLog();
        tlog.setId(UUIDUtil.getUUID());
        tlog.setCreateDate(new Date());
        tlog.setJobId(scheduleJob.getJobId().toString());
        tlog.setReason("未找到" + scheduleJob.getBeanClass() + "类下" + scheduleJob.getMethodName() + "对应的方法参数设置错误");
        tlog.setState("fail");
        sTimetaskLogService.insertSelective(tlog);
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        flag = false;
        STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
                STimetaskLogService.class);
        STimetaskLog tlog = new STimetaskLog();
        tlog.setId(UUIDUtil.getUUID());
        tlog.setCreateDate(new Date());
        tlog.setJobId(scheduleJob.getJobId().toString());
        tlog.setReason("未找到" + scheduleJob.getBeanClass() + "类下" + scheduleJob.getMethodName() + "对应的方法参数设置错误");
        tlog.setState("fail");
        sTimetaskLogService.insertSelective(tlog);
        e.printStackTrace();
      }
    }
    if (flag) {
      System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]----------启动成功");
      STimetaskLogService sTimetaskLogService = (STimetaskLogService) ApplicationContextUtils.getBean(
              STimetaskLogService.class);
      STimetaskLog tlog = new STimetaskLog();
      tlog.setId(UUIDUtil.getUUID());
      tlog.setCreateDate(new Date());
      tlog.setJobId(scheduleJob.getJobId().toString());
      tlog.setState("success");
      sTimetaskLogService.insertSelective(tlog);
    }

  }
}
