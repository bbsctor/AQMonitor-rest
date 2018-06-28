package io.renren.modules.history.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import io.renren.modules.history.entity.HistoryData;

public interface HistoryDataDao extends BaseMapper<HistoryData> {
	
	int deleteByPrimaryKey(Integer id);

    Integer insert(HistoryData record);

    int insertSelective(HistoryData record);

    HistoryData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HistoryData record);

    int updateByPrimaryKey(HistoryData record);
    
    List<HistoryData> getHistoryData(); //得到历史表所有数�?
    
    List<HistoryData> selectInfoByMN(String MN); //按照监测MN号获取对应数�?
    
    List<HistoryData> selectInfoBySiteName(String SiteName);//按照监测站名获取对应数据
     
    List<String> selectAllMN();  //获取�?有设备名
    
    List<Double> selectAllparam();  //获取�?有参数名
    
    List< HistoryData> queryByTime(Map<String, String> time);//时间段查�?
    
    List< HistoryData> queryByTimeAndMN(Map<String, String> time);//某一个站点时间段查询

}