package com.setting.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.setting.domain.LoginDTO;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;
import com.setting.persistence.PluginDAO;

@Service
public class PluginService {

	@Inject
	private PluginDAO dao;

	public UserVO login(LoginDTO dto) {
		return dao.login(dto);
	}

	public List<SettingVO> listSearchCriteria(SearchCriteria cri){
		return dao.listSearch(cri);
	}

	public int listSearchCount(SearchCriteria cri){
		return dao.listSearchCount(cri);
	}
}
