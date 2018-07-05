package com.stkj.modules.endpoint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.stkj.common.annotation.SysLog;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.R;
import com.stkj.common.validator.ValidatorUtils;
import com.stkj.common.validator.group.AddGroup;
import com.stkj.modules.endpoint.entity.StationInfo;
import com.stkj.modules.endpoint.service.StationInfoService;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;
import com.stkj.modules.sys.controller.AbstractController;
import com.stkj.modules.sys.entity.SysUserEntity;

@RestController
@RequestMapping("/station/stationinfo")
public class StationInfoController extends AbstractController {
	@Autowired
	private StationInfoService stationInfoService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("station:stationinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = stationInfoService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	@RequestMapping(value = "/data")
	@RequiresPermissions("station:stationinfo:data")
	public @ResponseBody List<StationInfo> TimeAndMN(@RequestParam Map<String, Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StationInfo> stationInfo = stationInfoService.queryData(params);
		logger.info(JSON.toJSONString(stationInfo));
	
		return stationInfo;
	}
	
	/**
	 * 保存站点信息
	 */
	@SysLog("保存站点信息")
	@RequestMapping("/save")
	@RequiresPermissions("station:stationinfo:save")
	public R save(@RequestBody StationInfo stationinfo){
		ValidatorUtils.validateEntity(stationinfo, AddGroup.class);
		
		stationInfoService.insert(stationinfo);
		
		return R.ok();
	}
}