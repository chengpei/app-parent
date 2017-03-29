package com.whpe.dao;

import com.whpe.bean.SysPeople;

public interface SysPeopleMapper {
    int insert(SysPeople record);

    int insertSelective(SysPeople record);
}