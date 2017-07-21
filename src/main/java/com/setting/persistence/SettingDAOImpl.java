package com.setting.persistence;

import com.setting.domain.Criteria;
import com.setting.domain.SettingVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Repository
public class SettingDAOImpl implements SettingDAO{

    private static String namespace = "com.setting.mappers.SettingMapper";

    @Inject
    private SqlSession session;

    @Override
    public List<SettingVO> list(SettingVO set) throws Exception {
        return session.selectList(namespace + ".list", set);
    }

    @Override
    public List<SettingVO> listPage(Integer page) throws Exception {

        if(page <= 0) {
            page = 1;
        }

        page = (page -1) * 10;
        return session.selectList(namespace + ".listPage", page);
    }

    @Override
    public List<SettingVO> listCriteria(Criteria cri) throws Exception {
        return session.selectList(namespace + ".listCriteria", cri);
    }

    @Override
    public SettingVO read(Integer bno) throws Exception {
        return session.selectOne(namespace + ".read", bno);
    }

    @Override
    public void write(SettingVO set) throws Exception {
        session.insert(namespace + ".write", set);
    }

    @Override
    public void write_con(SettingVO set) throws Exception {
        session.update(namespace + ".write_con", set);
    }

    @Override
    public void modify(SettingVO set) throws Exception {
        session.update(namespace + ".modify", set);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        session.delete(namespace + ".remove", bno);
    }

    @Override
    public void hit(Integer hit) throws Exception {
        session.update(namespace + ".hit", hit);
    }

    @Override
    public void rewrite(SettingVO set) throws Exception {
        session.insert(namespace + ".rewrite", set);
    }
}
