package com.setting.service;

import com.setting.domain.SettingVO;

import java.util.List;

/**
 * Created by Jinuk on 2017-07-11.
 */

public interface SettingService {
    List<SettingVO> list(SettingVO set);

    SettingVO read(Integer bno, Integer flag);

    void write(SettingVO set);
    void modify(SettingVO set);
    void remove(SettingVO set);
    void rewrite(SettingVO set);
}
