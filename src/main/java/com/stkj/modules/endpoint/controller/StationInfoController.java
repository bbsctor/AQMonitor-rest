package com.stkj.modules.endpoint.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.stkj.modules.sys.entity.SysDictEntity;
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
	
	@RequestMapping("/data")
	@RequiresPermissions("station:stationinfo:data")
	public List<StationInfo> TimeAndMN(@RequestParam Map<String, Object> params) {
		List<StationInfo> stationInfo = stationInfoService.queryData(params);
	
		return stationInfo;
	}
	
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:dict:info")
    public R info(@PathVariable("id") Long id){
        StationInfo stationinfo = stationInfoService.selectById(id);

        return R.ok().put("stationinfo", stationinfo);
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
	
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("station:stationinfo:update")
    public R update(@RequestBody StationInfo stationinfo){
        //校验类型
        ValidatorUtils.validateEntity(stationinfo);

        stationInfoService.updateById(stationinfo);

        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("station:stationinfo:delete")
    public R delete(@RequestBody Long[] ids){
    	stationInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}