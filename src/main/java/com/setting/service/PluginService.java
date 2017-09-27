package com.setting.service;

import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;

import java.util.List;

public interface PluginService {
	
	List<SettingVO> listSearchCriteria(SearchCriteria cri);
	int listSearchCount(SearchCriteria cri);

}
