package com.stkj.modules.history.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.stkj.common.utils.PageUtils;
import com.stkj.modules.history.entity.HistoryData;
import com.stkj.modules.realtime.entity.RealData;

public interface HistoryDataService extends IService<HistoryData> {
	
	PageUtils queryPage(Map<String, Object> params);

	List<HistoryData> queryData(Map<String, Object> params);
}
