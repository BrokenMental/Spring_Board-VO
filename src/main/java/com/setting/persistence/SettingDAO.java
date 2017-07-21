package com.setting.persistence;

import com.setting.domain.Criteria;
import com.setting.domain.SettingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */
public interface SettingDAO {
    List<SettingVO> list(SettingVO set) throws Exception;
    List<SettingVO> listPage(Integer page) throws Exception;
    List<SettingVO> listCriteria(Criteria cri) throws Exception;

    SettingVO read(Integer bno) throws Exception;

    void write(SettingVO set) throws Exception;
    void write_con(SettingVO set) throws Exception;

    void modify(SettingVO set) throws Exception;
    void remove(Integer bno) throws Exception;
    void hit(Integer hit) throws Exception;
    void rewrite(SettingVO set) throws Exception;
}
