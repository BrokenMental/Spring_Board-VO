package com.setting.persistence;

import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PluginDAOImpl implements PluginDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.test.mapper.BoardMapper";

	@Override
	public List<SettingVO> listSearch(SearchCriteria cri){
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri){
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
}
