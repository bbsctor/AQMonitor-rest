package com.stkj.modules.endpoint.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stkj.common.utils.Constant;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.Query;
import com.stkj.modules.endpoint.dao.StationInfoDao;
import com.stkj.modules.endpoint.entity.StationInfo;
import com.stkj.modules.endpoint.service.StationInfoService;
import com.stkj.modules.realtime.dao.RealDataDao;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;
import com.stkj.modules.sys.shiro.ShiroUtils;

@Service("stationInfoService")
public class StationInfoServiceImpl extends ServiceImpl<StationInfoDao, StationInfo> implements StationInfoService {

	@Resource
	private StationInfoDao stationInfoDao;
	private List<StationInfo> stationInfo;
	
	@Override
	//@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		String mn = (String)params.get("mn");
		Page<StationInfo> page;

			page = this.selectPage(
					new Query<StationInfo>(params).getPage(),
					new EntityWrapper<StationInfo>()
						.like(StringUtils.isNotBlank(mn),"mn", mn)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
				);
		
		
		return new PageUtils(page);
	}

	@Override
	public List<StationInfo> queryData(Map<String, Object> params) {
		String mn = (String)params.get("mn");

		List<StationInfo> list = null;
		
			list = this.selectList(
					new EntityWrapper<StationInfo>()
						.like(StringUtils.isNotBlank(mn),"mn", mn)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
			);
		return list;
	}
	
}