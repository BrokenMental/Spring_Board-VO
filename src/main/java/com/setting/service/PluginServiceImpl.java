package com.setting.service;

import java.util.List;

import javax.inject.Inject;

import com.setting.domain.*;
import com.setting.persistence.PluginDAO;
import org.springframework.stereotype.Service;

@Service
public class PluginServiceImpl implements PluginService {

	@Inject
	private PluginDAO dao;

	@Override
	public UserVO login(LoginDTO dto) {
		return dao.login(dto);
	}

	@Override
	public List<SettingVO> listSearchCriteria(SearchCriteria cri){
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri){
		return dao.listSearchCount(cri);
	}
}
