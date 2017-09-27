package com.setting.service;

import java.util.List;

import javax.inject.Inject;

import com.setting.domain.Criteria;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.persistence.PluginDAO;
import org.springframework.stereotype.Service;

@Service
public class PluginServiceImpl implements PluginService {

	@Inject
	private PluginDAO dao;

	@Override
	public List<SettingVO> listCriteria(Criteria cri){
		return dao.listCriteria(cri);
	}

	@Override
	public List<SettingVO> listSearchCriteria(SearchCriteria cri){
		return dao.listSearch(cri);
	}
	
	@Override
	public int listCountCriteria(Criteria cri) {
		return dao.countPaging(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri){
		return dao.listSearchCount(cri);
	}
}
