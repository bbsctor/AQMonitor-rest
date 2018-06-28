package com.stkj.AQMonitor.module.endpoint.dao;

import org.apache.ibatis.annotations.Mapper;

import com.stkj.AQMonitor.module.endpoint.entity.StationInfo;

@Mapper
public interface StationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    StationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StationInfo record);

    int updateByPrimaryKey(StationInfo record);
}