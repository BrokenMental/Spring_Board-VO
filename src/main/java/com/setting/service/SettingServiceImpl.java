package com.setting.service;

import com.setting.domain.SettingVO;
import com.setting.persistence.SettingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Service
public class SettingServiceImpl implements SettingService {

    @Inject
    private SettingDAO dao;

    @Override
    public List<SettingVO> list(SettingVO set) throws Exception {
        return dao.list(set);
    }

    @Override
    public SettingVO read(Integer bno) throws Exception {
        return dao.read(bno);
    }

    @Override
    public void write(SettingVO set) throws Exception {
        dao.write(set);
    }

    @Override
    public void modify(SettingVO set) throws Exception {
        dao.modify(set);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        dao.remove(bno);
    }
}