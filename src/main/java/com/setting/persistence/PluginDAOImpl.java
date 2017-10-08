package com.setting.persistence;

import com.setting.domain.LoginDTO;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PluginDAOImpl implements PluginDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.setting.mappers.PluginMapper";
	private static String namespaceuser = "com.setting.mappers.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) {
		return session.selectOne(namespaceuser + ".login", dto);
	}

	@Override
	public List<SettingVO> listSearch(SearchCriteria cri){
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri){
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
}
