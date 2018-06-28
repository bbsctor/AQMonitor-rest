package com.stkj.AQMonitor.module.endpoint.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stkj.AQMonitor.module.endpoint.entity.StationMn;


@Mapper
public interface StationMnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StationMn record);

    int insertSelective(StationMn record);

    StationMn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StationMn record);

    int updateByPrimaryKey(StationMn record);
    
    List<String> selectALLMNName();
     
    
}