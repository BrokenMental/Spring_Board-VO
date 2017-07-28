package com.setting.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;
import com.setting.persistence.SettingDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.messaging.simp.stomp.StompHeaders.LOGIN;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Service
public class SettingServiceImpl implements SettingService {
    //private SettingVO tempVO = new SettingVO();

    @Inject
    private SettingDAO dao;

    @Override
    public List<SettingVO> list(SettingVO set){
        return dao.list(set);
    }

    @Override
    public SettingVO read(Integer bno, Integer flag){
        if (flag == 1) {
            dao.hit(bno);
        }
        /*tempVO = dao.read(bno);
        return tempVO;*/

        /* VO 복사시에 아래의 명령문을 실행한다. */
        //BeanUtils.copyProperties(sourceVO,targetVO);
        return dao.read(bno);
    }

    @Override
    public void write(SettingVO set, String id){
        set.setId(id);
        dao.write(set);
        int num = set.getBno();
        while (num > 1) {
            num = num - 1;
            set.setBno(num);
            dao.write_con(set);
        }
    }

    @Override
    public void modify(SettingVO set){
        dao.modify(set);
    }

    @Override
    public void remove(SettingVO set){
        int lvl = set.getLvl() + 1;
        int maxlvl = dao.maxlvl();

        dao.remove(set);

        while (lvl <= maxlvl) {
            set.setLvl(lvl);
            dao.lvldown(set);

            lvl += 1;
        }
    }

    @Override
    public void rewrite(SettingVO set, String id){
        int temp = set.getLvl();
        int lvl = temp + 1;
        int maxlvl = dao.maxlvl();
        while (lvl <= maxlvl) {
            set.setLvl(maxlvl);
            dao.lvlup(set);

            maxlvl -= 1;
        }
        set.setLvl(temp);
        set.setId(id);
        dao.rewrite(set);
    }
}
