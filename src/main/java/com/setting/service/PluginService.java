package com.setting.service;

import com.setting.domain.LoginDTO;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;

import java.util.List;

public interface PluginService {

	UserVO login(LoginDTO dto);
	List<SettingVO> listSearchCriteria(SearchCriteria cri);
	int listSearchCount(SearchCriteria cri);

}
