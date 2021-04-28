package com.zgb.quartz.admin.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 
 *
 * @param <T>
 * @param <TE>
 * @param <PK>
 */
public interface GenericMapper<T, TE, PK> {
    int countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TE example);

    T selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") TE example);

    int updateByExample(T record, TE example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
