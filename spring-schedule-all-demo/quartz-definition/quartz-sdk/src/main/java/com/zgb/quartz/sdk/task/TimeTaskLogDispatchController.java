package com.zgb.quartz.sdk.task;

import org.springframework.stereotype.Component;

/**
 * 定时清除timeTaskLog 7天之前的记录
 */
@Component
public class TimeTaskLogDispatchController {
  private static final Logger LOGGER = Logger.getLogger(TimeTaskLogDispatchController.class);

  /**
   * 定时清除timeTaskLog 7天之前的记录
   */
  public void deleteTimeTaskLog(String data) {
    LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始执行");

    STimetaskLogService bActiveService = (STimetaskLogService) ApplicationContextUtils.getBean(
            STimetaskLogService.class);
    Date currentDate = new Date();
    int day = -7;
    Date deleteDate = DateUtil.getAfterNumDay(currentDate, day);
    int ret = bActiveService.deleteLog(deleteDate);
    if (ret > 0) {
      LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>执行成功");
    } else {
      LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>执行失败");
    }
  }
}