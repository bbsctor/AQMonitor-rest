package com.stkj.modules.endpoint.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.stkj.common.utils.PageUtils;
import com.stkj.modules.endpoint.entity.StationInfo;

public interface StationInfoService extends IService<StationInfo> {
	
	PageUtils queryPage(Map<String, Object> params);
	
	List<StationInfo> queryData(Map<String, Object> params);
}
