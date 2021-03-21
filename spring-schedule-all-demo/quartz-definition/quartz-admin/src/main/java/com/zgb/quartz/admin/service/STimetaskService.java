package com.zgb.quartz.admin.service;

import com.zgb.quartz.admin.pojo.entity.STimetask;
import com.zgb.quartz.admin.pojo.entity.STimetaskExample;
import com.zgb.quartz.common.interceptor.Page;

import java.util.List;

/**
 * Generate By MBG
 **/
public interface STimetaskService extends GenericService<STimetask, STimetaskExample, String> {
  /**
   * According to the model information query object
   *
   * @return
   **/
  STimetask queryByModel(STimetask sTimetask);

  /**
   * 分页查询
   *
   * @param task
   * @param page
   * @return
   */
  List<STimetask> selectByPage(STimetask task, Page page);

  /**
   * @param idList
   * @param type
   * @return
   */
  int updatebyOperate(List<String> idList, String type);

  /**
   * 删除
   *
   * @param idList
   * @return
   */
  int deleteByIds(List<String> idList);

  /**
   * 新增或更新
   *
   * @param task
   * @param loginName
   * @return
   */
  int insertOrUpdateByUser(STimetask task, String loginName);

  /**
   * 验证组是否存在
   *
   * @param task
   * @return
   */
  STimetask checkName(STimetask task);
}