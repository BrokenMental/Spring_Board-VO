package com.setting.persistence;

import com.setting.domain.SettingVO;

import java.util.List;

/**
 * Created by Jinuk on 2017-07-11.
 */
public interface SettingDAO {
    List<SettingVO> list(SettingVO set) throws Exception;

    SettingVO read(Integer bno) throws Exception;

    void write(SettingVO set) throws Exception;
    void write_con(SettingVO set) throws Exception;

    void modify(SettingVO set) throws Exception;
    void remove(SettingVO set) throws Exception;
    void lvldown(SettingVO set) throws Exception;
    void hit(Integer hit) throws Exception;
    void rewrite(SettingVO set) throws Exception;
    void lvlup(SettingVO set) throws Exception;
    int maxlvl() throws Exception;
}
