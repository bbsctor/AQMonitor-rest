package com.stkj.modules.history.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stkj.common.utils.Constant;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.Query;
import com.stkj.modules.history.dao.HistoryDataDao;
import com.stkj.modules.history.entity.HistoryData;
import com.stkj.modules.history.service.HistoryDataService;
import com.stkj.modules.realtime.entity.RealData;

@Service("historyDataService")
public class HistoryDataServiceImpl extends ServiceImpl<HistoryDataDao, HistoryData>
					implements HistoryDataService {

	@Override
	//@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		String username = (String)params.get("username");

		Page<HistoryData> page = this.selectPage(
			new Query<HistoryData>(params).getPage(),
			new EntityWrapper<HistoryData>()
				.like(StringUtils.isNotBlank(username),"username", username)
				.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
		);
		
		return new PageUtils(page);
	}

	@Override
	public List<HistoryData> queryData(Map<String, Object> params) {
		String username = (String)params.get("mn");
		String begindate = (String)params.get("begindate");
		String enddate = (String)params.get("enddate");
		List<HistoryData> list = null;
		
		if(begindate != null && enddate != null)
		{
			list = this.selectList(
					new EntityWrapper<HistoryData>()
						.like(StringUtils.isNotBlank(username),"mn", username)
						.between("time", begindate, enddate)
						.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
			);
		}
		return list;
	}
}