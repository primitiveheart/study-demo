package com.zgb.quartz.admin.mapper;

import com.zgb.quartz.admin.pojo.entity.STimetask;
import com.zgb.quartz.admin.pojo.entity.STimetaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Generate By MBG
**/
public interface STimetaskMapper extends GenericMapper<STimetask, STimetaskExample, String> {

 /**
  * 更新状态
  * @param idList
  * @return
  */
 int updateByIds(@Param("idList") List<String> idList, @Param("type") String type);

 /**
  * 更新状态
  * @param idList
  * @return
  */
 int deleteByIds(@Param("idList") List<String> idList);
}