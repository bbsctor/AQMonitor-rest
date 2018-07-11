package com.stkj.modules.gis.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.stkj.common.utils.R;
import com.stkj.modules.endpoint.entity.StationInfo;
import com.stkj.modules.endpoint.service.StationInfoService;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;
import com.stkj.modules.sys.controller.AbstractController;

@RestController
@RequestMapping("/gis")
public class GisController extends AbstractController {
	@Autowired
	private StationInfoService stationInfoService;
	@Autowired
	private RTDataService rtDataService;
	
	@RequestMapping("/stationinfo")
	@RequiresPermissions("gis:stationinfo")
	public List<StationInfo> TimeAndMN(@RequestParam Map<String, Object> params) {
		List<StationInfo> stationInfo = stationInfoService.queryData(params);
	
		return stationInfo;
	}
	
    /**
     * 信息
     */
    @RequestMapping("/latestdata/{mn}")
    @RequiresPermissions("gis:latestdata")
	public List<RealData> RTDataByID(@PathVariable("mn") String mn) {
		List<RealData> realData =rtDataService.queryLatestDataByMN(mn);
		logger.info(JSON.toJSONString(realData));
	
		return realData;
	}
}