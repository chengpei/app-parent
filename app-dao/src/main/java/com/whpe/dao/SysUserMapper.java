package com.whpe.dao;

import com.whpe.bean.SysUser;

public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);
}