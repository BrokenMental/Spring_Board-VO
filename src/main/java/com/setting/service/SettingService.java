package com.setting.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.setting.domain.SettingVO;
import com.setting.persistence.SettingDAO;

/**
 * Created by Jinuk on 2017-07-11.
 */

@Service
public class SettingService {
    //private SettingVO tempVO = new SettingVO();

    @Inject
    private SettingDAO dao;

    public List<SettingVO> list(SettingVO set){
        return dao.list(set);
    }

    public SettingVO read(Integer bno, Integer flag){
        if (flag == 1) {
            dao.hit(bno);
        }
        /*tempVO = dao.read(bno);
        return tempVO;*/

        /* VO ����ÿ� �Ʒ��� ��ɹ��� �����Ѵ�. */
        //BeanUtils.copyProperties(sourceVO,targetVO);
        SettingVO temp = dao.read(bno);
        temp.setContents(temp.getContents().replace("<br>","\r\n")); //textarea ���͹��� �ذ���
        return temp;
    }

    public void write(SettingVO set, String id){
        set.setId(id);
        set.setContents(set.getContents().replace("\r\n","<br>")); //textarea ���͹��� �ذ���
        set.setContents(secureco(set.getContents()));
        set.setTitle(secureco(set.getTitle()));
        dao.write(set);
        int num = set.getBno();
        while (num > 1) {
            num = num - 1;
            set.setBno(num);
            dao.write_con(set);
        }
    }

    public void modify(SettingVO set){
        dao.modify(set);
    }

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

    /*SQL INJECTION ��ť���ڵ�*/
    public String secureco(String text){
        text.replaceAll("<","&#60");
        text.replaceAll(">","&#62");
        text.replaceAll("/","&#47");
    	return text;
    }
}
