package com.stkj.modules.realtime.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.R;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;
import com.stkj.modules.sys.controller.AbstractController;

@RestController
@RequestMapping("/realtime/rtdata")
public class RTDataController extends AbstractController {
	@Autowired
	private RTDataService rtDataService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("realtime:rtdata:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = rtDataService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	@RequestMapping("/data")
	@RequiresPermissions("realtime:rtdata:data")
//	public R TimeAndMN(@RequestParam Map<String, Object> params) {
//		List<RealData> realData =rtDataService.queryData(params);
//	
//		return R.ok().put("data", realData);
//	}
	
	public List<RealData> TimeAndMN(@RequestParam Map<String, Object> params) {
		List<RealData> realData =rtDataService.queryData(params);
		logger.info(JSON.toJSONString(realData));
	
		return realData;
	}
}