package io.renren.modules.realtime.controller;

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

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.realtime.entity.RealData;
import io.renren.modules.realtime.service.RTDataService;
import io.renren.modules.sys.controller.AbstractController;

@RestController
@RequestMapping("/realtime/rtdata")
public class RTDataController extends AbstractController {
	@Autowired
	private RTDataService rtDataService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = rtDataService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	@RequestMapping(value = "/QueryByTimeAndMN")
	public @ResponseBody List<RealData> TimeAndMN(@RequestParam Map<String, Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<RealData> RealData =rtDataService.queryData(params);
		logger.info(JSON.toJSONString(RealData));
	
		return RealData;
	}
}