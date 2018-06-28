package io.renren.modules.realtime.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import io.renren.modules.realtime.entity.RealData;

public interface RealDataDao extends BaseMapper<RealData> {
	
	int deleteByPrimaryKey(Integer id);

    int insertSelective(RealData record);  

    int updateByPrimaryKeySelective(RealData record);

    int updateByPrimaryKey(RealData record);	
	
	    RealData selectByPrimaryKey(Integer id);

	    List<RealData> getRealData(); //得到实时表所有数�?
	    
	    List<RealData> selectInfoByMN(String MN); //按照设备号获取对应数�?
	    
	    List<String> selectAllMN();  //获取�?有设备号
	    
	    List<RealData> selectByTime(Map<String, String> map);//时间段查�?
	    
	    List<Map<String, Object>> selectAllData();//导出操作
	    
	    List< RealData> queryByTimeAndMN(Map<String, String> time);//某一个站点时间段查询

}