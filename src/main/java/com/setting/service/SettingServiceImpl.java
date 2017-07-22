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

    public boolean conlvl(String num) {
        if (num == null) {
            return false;
        } else {
            return true;
        }
    }

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
    public void remove(Integer bno) throws Exception {
        dao.remove(bno);
    }

    @Override
    public void rewrite(SettingVO set) throws Exception {
        //int num = set.getBno();
        int temp = set.getLvl();
        int lvl = temp+1;
        int maxlvl = dao.maxlvl();
        System.out.println("temp = "+temp);
        System.out.println("lvl = "+lvl);
        System.out.println("maxlvl = "+maxlvl);
        //boolean flag = conlvl(Integer.toString(lvl));

        while (lvl <= maxlvl) {
            set.setLvl(maxlvl);
            System.out.println("maxlvl = "+maxlvl);
            dao.lvlup(set);
            System.out.println("pass");

            maxlvl -=1;
        }
        set.setLvl(temp);
        dao.rewrite(set);
        /*while(num > 1){
            num = num-1;
            set.setBno(num);
            dao.write_con(set);
        }*/
        }
    }
