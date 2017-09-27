package com.setting.persistence;

import com.setting.domain.Criteria;
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
	public List<SettingVO> listPage(int page){
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<SettingVO> listCriteria(Criteria cri){
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri){
		return session.selectOne(namespace + ".countPaging", cri);
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
