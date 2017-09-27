package com.setting.persistence;

import com.setting.domain.Criteria;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;

import java.util.List;

public interface PluginDAO {
	public List<SettingVO> listPage(int page);
	public List<SettingVO> listSearch(SearchCriteria cri);
	public List<SettingVO> listCriteria(Criteria cri);

	public int listSearchCount(SearchCriteria cri);
	public int countPaging(Criteria cri);
}
