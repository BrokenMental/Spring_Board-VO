package com.setting.persistence;

import com.setting.domain.SettingVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

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
    public void remove(SettingVO set) throws Exception {
        session.delete(namespace + ".remove", set);
    }

    @Override
    public void lvldown(SettingVO set) throws Exception {
        session.update(namespace + ".lvldown", set);
    }

    @Override
    public void hit(Integer hit) throws Exception {
        session.update(namespace + ".hit", hit);
    }

    @Override
    public void rewrite(SettingVO set) throws Exception {
        System.out.println("출력되는것좀 보자(4) ==> "+set);
        session.insert(namespace + ".rewrite", set);
    }

    @Override
    public void lvlup(SettingVO set) throws Exception {
        session.update(namespace + ".lvlup", set);
    }

    @Override
    public int maxlvl() throws Exception {
        return session.selectOne(namespace + ".maxlvl");
    }
}
