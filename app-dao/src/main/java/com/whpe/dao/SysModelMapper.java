package com.whpe.dao;

import com.whpe.bean.SysModel;

public interface SysModelMapper {
    int deleteByPrimaryKey(String modelId);

    int insert(SysModel record);

    int insertSelective(SysModel record);

    SysModel selectByPrimaryKey(String modelId);

    int updateByPrimaryKeySelective(SysModel record);

    int updateByPrimaryKey(SysModel record);
}