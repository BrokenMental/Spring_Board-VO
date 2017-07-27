package com.setting.controller;

import com.setting.domain.PageMaker;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.service.PluginService;
import com.setting.service.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by Jinuk on 2017-07-17.
 */
@Controller
@RequestMapping(value = "/Board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    static String session_id;
    int flag = 0;

    @Autowired
    PluginService servicePlug;
    @Autowired
    SettingService serviceSet;

    @RequestMapping(value = "/ListBoard", method = RequestMethod.GET)
    public void ListBoardGET(@ModelAttribute("cri") SearchCriteria cri,@ModelAttribute("id") String id, Model model){
        logger.info("===============|BOARD LIST|===============");
        logger.info(id);
        session_id = id;
        //model.addAttribute("id", id); //@ModelAttribute("") 를 사용하면 이 문장을 사용하지 않아도 모델로 전달한다.
        logger.info(cri.toString());
        model.addAttribute("list", servicePlug.listSearchCriteria(cri));

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(servicePlug.listSearchCount(cri));

        model.addAttribute("pageMaker", pageMaker);
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.GET)
    public void NewBoardGET(@ModelAttribute("id") String id){
        logger.info("===============|BOARD NEW GET|===============");
        logger.info(id);
        //return "Board/NewBoard"; // void가 아닌 다른 타입으로 반환형을 선언할 경우 필요
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.POST)
    public String NewBoardPOST(SettingVO set){
        logger.info("==============|BOARD NEW POST|===============");
        logger.info(set.toString());
        serviceSet.write(set);
        return "redirect:/Board/ListBoard";
    }

    @RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
    public void ReadBoardGET(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, @ModelAttribute("id") String id, Model model){
        logger.info("==============|BOARD READ|===============");
        logger.info("id : " +id);
        flag = 1;
        model.addAttribute(serviceSet.read(bno, flag));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
    public void ModifyBoardGET(int bno,@ModelAttribute("id") String id, Model model){
        logger.info("============|BOARD MODIFY GET|=============");
        logger.info("id : " +id);
        flag = 0;
        model.addAttribute(serviceSet.read(bno, flag));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.POST)
    public String ModifyBoardPOST(SettingVO set){
        logger.info("============|BOARD MODIFY POST|=============");
        serviceSet.modify(set);
        return "redirect:/Board/ListBoard";
    }

    @RequestMapping(value = "/RemoveBoard", method = RequestMethod.POST)
    public String RemoveBoard(SettingVO set){
        logger.info("============|BOARD REMOVE|=============");
        serviceSet.remove(set);
        return "redirect:/Board/ListBoard";
    }

    @RequestMapping(value = "/ReBoard", method = RequestMethod.GET)
    public void ReBoardGET(int bno, @ModelAttribute("id") String id, Model model){
        logger.info("=========|BOARD RE GET|==========");
        logger.info("id : " +id);
        flag = 0;
        model.addAttribute(serviceSet.read(bno, flag));
    }

    @RequestMapping(value = "/ReBoard", method = RequestMethod.POST)
    public String ReBoardPOST(SettingVO set){
        logger.info("===========|BOARD RE POST|============");
        logger.info(set.toString());
        serviceSet.rewrite(set);
        return "redirect:/Board/ListBoard";
    }
}
