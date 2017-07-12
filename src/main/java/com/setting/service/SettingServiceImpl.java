package com.setting.service;

import com.setting.domain.SettingVO;
import com.setting.persistence.SettingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Service
public class SettingServiceImpl implements SettingService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private SettingDAO dao;

    @Override
    public List<SettingVO> list(SettingVO set) throws Exception {
        return dao.list(set);
    }
}
