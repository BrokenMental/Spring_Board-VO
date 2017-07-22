package com.setting.service;

import com.setting.domain.SettingVO;

import java.util.List;

/**
 * Created by Jinuk on 2017-07-11.
 */

public interface SettingService {
    List<SettingVO> list(SettingVO set) throws Exception;

    SettingVO read(Integer bno, Integer flag) throws Exception;

    void write(SettingVO set) throws Exception;
    void modify(SettingVO set) throws Exception;
    void remove(SettingVO set) throws Exception;
    void rewrite(SettingVO set) throws Exception;
}
