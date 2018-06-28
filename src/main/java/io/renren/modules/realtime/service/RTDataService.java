package io.renren.modules.realtime.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.realtime.entity.RealData;

public interface RTDataService extends IService<RealData> {
	
	PageUtils queryPage(Map<String, Object> params);
	
	List<RealData> queryData(Map<String, Object> params);
}
