package com.stkj.modules.realtime.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stkj.common.utils.Constant;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.Query;
import com.stkj.modules.realtime.dao.RealDataDao;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;

@Service("rtDataService")
public class RTDataServiceImpl extends ServiceImpl<RealDataDao, RealData> implements RTDataService {

	@Resource
	private RealDataDao realDataDao;
	private List<RealData> RealData;
	
	@Override
	//@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		String mn = (String)params.get("mn");
		String begindatetime = (String)params.get("begindatetime");
		String enddatetime = (String)params.get("enddatetime");
		Page<RealData> page;
		
		if(begindatetime != null && enddatetime != null && begindatetime.isEmpty() == false && enddatetime.isEmpty() == false  )
		{
			page = this.selectPage(
					new Query<RealData>(params).getPage(),
					new EntityWrapper<RealData>()
						.like(StringUtils.isNotBlank(mn),"mn", mn)
						.between("time", begindatetime, enddatetime)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
				);
		}
		else
		{
			page = this.selectPage(
					new Query<RealData>(params).getPage(),
					new EntityWrapper<RealData>()
						.like(StringUtils.isNotBlank(mn),"mn", mn)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
				);
		}
		
		
		return new PageUtils(page);
	}

	@Override
	public List<RealData> queryData(Map<String, Object> params) {
		String username = (String)params.get("mn");
		String begindate = (String)params.get("begindatetime");
		String enddate = (String)params.get("enddatetime");
		List<RealData> list = null;
		
		if(begindate != null && enddate != null)
		{
			list = this.selectList(
					new EntityWrapper<RealData>()
						.like(StringUtils.isNotBlank(username),"mn", username)
						.between("time", begindate, enddate)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
			);
		}
		return list;
	}
}