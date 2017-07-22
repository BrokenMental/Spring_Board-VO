package com.setting.service;

import com.setting.domain.SettingVO;
import com.setting.persistence.SettingDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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
    public SettingVO read(Integer bno, Integer flag) throws Exception {
        if (flag == 1) {
            dao.hit(bno);
        }
        return dao.read(bno);
    }

    @Override
    public void write(SettingVO set) throws Exception {
        dao.write(set);
        int num = set.getBno();
        while (num > 1) {
            num = num - 1;
            set.setBno(num);
            dao.write_con(set);
        }
    }

    @Override
    public void modify(SettingVO set) throws Exception {
        dao.modify(set);
    }

    @Override
    public void remove(SettingVO set) throws Exception {
        int lvl = set.getLvl()+1;
        int maxlvl = dao.maxlvl();

        dao.remove(set);

        while (lvl <= maxlvl) {
            set.setLvl(lvl);
            dao.lvldown(set);

            lvl +=1;
        }
    }

    @Override
    public void rewrite(SettingVO set) throws Exception {
        int temp = set.getLvl();
        int lvl = temp+1;
        int maxlvl = dao.maxlvl();

        while (lvl <= maxlvl) {
            set.setLvl(maxlvl);
            dao.lvlup(set);

            maxlvl -=1;
        }
        set.setLvl(temp);
        dao.rewrite(set);
        }
    }
