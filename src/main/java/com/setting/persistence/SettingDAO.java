package com.setting.persistence;

import com.setting.domain.SettingVO;

import java.util.List;

/**
 * Created by Jinuk on 2017-07-11.
 */
public interface SettingDAO {
    List<SettingVO> list(SettingVO set);

    SettingVO read(Integer bno);

    void write(SettingVO set);
    void write_con(SettingVO set);

    void modify(SettingVO set);
    void remove(SettingVO set);
    void lvldown(SettingVO set);
    void hit(Integer hit);

    void rewrite(SettingVO set);
    void lvlup(SettingVO set);
    int maxlvl();
}
