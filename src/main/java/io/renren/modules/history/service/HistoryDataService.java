package io.renren.modules.history.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.history.entity.HistoryData;
import io.renren.modules.realtime.entity.RealData;

public interface HistoryDataService extends IService<HistoryData> {
	
	PageUtils queryPage(Map<String, Object> params);

	List<HistoryData> queryData(Map<String, Object> params);
}
