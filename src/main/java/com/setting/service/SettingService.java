package com.setting.service;

import com.setting.domain.SettingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */

public interface SettingService {
    List<SettingVO> list(SettingVO set) throws Exception;
    SettingVO read(Integer idx) throws Exception;

    void write(SettingVO set) throws Exception;
    void modify(SettingVO set) throws Exception;
}
