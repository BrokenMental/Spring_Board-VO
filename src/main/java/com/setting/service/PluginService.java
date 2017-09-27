package com.setting.service;

import com.setting.domain.Criteria;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;

import java.util.List;

public interface PluginService {
	public List<SettingVO> listCriteria(Criteria cri);
	
	public List<SettingVO> listSearchCriteria(SearchCriteria cri);
	
	public int listSearchCount(SearchCriteria cri);
	
	public int listCountCriteria(Criteria cri);
}
