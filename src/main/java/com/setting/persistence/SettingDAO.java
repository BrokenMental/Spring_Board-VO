package com.setting.persistence;

import com.setting.domain.SettingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */
public interface SettingDAO {
    List<SettingVO> list(SettingVO set) throws Exception;
    void Write(SettingVO set) throws Exception;
}
