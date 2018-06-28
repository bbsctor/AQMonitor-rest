package io.renren.modules.history.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.history.entity.HistoryData;
import io.renren.modules.history.service.HistoryDataService;
import io.renren.modules.sys.controller.AbstractController;

@RestController
@RequestMapping("/history/historydata")
public class HistoryDataController extends AbstractController {
	@Autowired
	private HistoryDataService historyDataService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = historyDataService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	@RequestMapping(value = "/QueryByTimeAndMN")
	public @ResponseBody List<HistoryData> TimeAndMN(@RequestParam Map<String, Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HistoryData> historyData =historyDataService.queryData(params);
		logger.info(JSON.toJSONString(historyData));
	
		return historyData;
	}
}