package com.setting.persistence;

import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;

import java.util.List;

public interface PluginDAO {
	List<SettingVO> listSearch(SearchCriteria cri);
	int listSearchCount(SearchCriteria cri);
}
