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
        SettingVO temp = dao.read(bno);
        temp.setContents(temp.getContents().replace("<br>","\r\n")); //textarea 엔터문제 해결방법
        return temp;
    }

    @Override
    public void write(SettingVO set, String id){
        set.setId(id);
        set.setContents(set.getContents().replace("\r\n","<br>")); //textarea 엔터문제 해결방법
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
