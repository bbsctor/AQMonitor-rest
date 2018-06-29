package com.stkj.modules.realtime.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.stkj.common.utils.PageUtils;
import com.stkj.modules.realtime.entity.RealData;

public interface RTDataService extends IService<RealData> {
	
	PageUtils queryPage(Map<String, Object> params);
	
	List<RealData> queryData(Map<String, Object> params);
}
