package com.setting.persistence;

import com.setting.domain.LoginDTO;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;

import java.util.List;

public interface PluginDAO {

	UserVO login(LoginDTO dto);
	List<SettingVO> listSearch(SearchCriteria cri);
	int listSearchCount(SearchCriteria cri);
}
