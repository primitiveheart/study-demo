package com.zgb.quartz.admin.service;

import com.zgb.quartz.admin.pojo.entity.STimetaskLog;
import com.zgb.quartz.admin.pojo.entity.STimetaskLogExample;

import java.util.Date;

/**
 * Generate By MBG
 **/
public interface STimetaskLogService extends GenericService<STimetaskLog, STimetaskLogExample, String> {
  /**
   * According to the model information query object
   *
   * @return
   **/
  STimetaskLog queryByModel(STimetaskLog sTimetaskLog);

  /**
   * 清除指定时间之前的log记录
   *
   * @param deleteDateStr
   */
  int deleteLog(Date deleteDateStr);
}