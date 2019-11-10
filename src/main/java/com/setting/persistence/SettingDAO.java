package com.setting.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.setting.domain.SettingVO;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Repository
public class SettingDAO{

    private static String namespace = "com.setting.mappers.SettingMapper";

    @Inject
    private SqlSession session;

    public List<SettingVO> list(SettingVO set){
        return session.selectList(namespace + ".list", set);
    }

    public SettingVO read(Integer bno){
        return session.selectOne(namespace + ".read", bno);
    }

    public void write(SettingVO set){
        session.insert(namespace + ".write", set);
    }

    public void write_con(SettingVO set){
        session.update(namespace + ".write_con", set);
    }

    public void modify(SettingVO set){
        session.update(namespace + ".modify", set);
    }

    public void remove(SettingVO set){
        session.delete(namespace + ".remove", set);
    }

    public void lvldown(SettingVO set){
        session.update(namespace + ".lvldown", set);
    }

    public void hit(Integer hit){
        session.update(namespace + ".hit", hit);
    }

    public void rewrite(SettingVO set){
        session.insert(namespace + ".rewrite", set);
    }

    public void lvlup(SettingVO set){
        session.update(namespace + ".lvlup", set);
    }

    public int maxlvl(){
        return session.selectOne(namespace + ".maxlvl");
    }
}
