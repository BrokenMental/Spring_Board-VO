package com.setting.controller;

import com.setting.domain.SettingVO;
import com.setting.service.SettingService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    int flag = 0;

    @Inject
    SettingService service;

    @RequestMapping(value = "/ListBoard", method = RequestMethod.GET)
    public void ListBoardGET(SettingVO set, Model model, Locale locale) throws Exception{
        logger.info("Welcome home! The client locale is {}.", locale);
        logger.info("===============|BOARD LIST|===============");
        model.addAttribute("list", service.list(set));
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.GET)
    public void NewBoardGET() throws Exception{
        logger.info("===============|BOARD NEW GET|===============");
        //return "Board/NewBoard"; // void가 아닌 다른 타입으로 반환형을 선언할 경우 필요
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.POST)
    public String NewBoardPOST(SettingVO set) throws Exception{
        logger.info("==============|BOARD NEW POST|===============");
        logger.info(set.toString());
        service.write(set);
        return "redirect:/";
    }

    @RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
    public void ReadBoardGET(@RequestParam("bno") int bno, Model model) throws Exception{
        logger.info("==============|BORAD READ|===============");
        flag = 1;
        model.addAttribute(service.read(bno, flag));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
    public void ModifyBoardGET(int bno, Model model) throws  Exception{
        logger.info("============|BOARD MODIFY GET|=============");
        flag = 0;
        model.addAttribute(service.read(bno, flag));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.POST)
    public String ModifyBoardPOST(SettingVO set) throws Exception{
        logger.info("============|BOARD MODIFY POST|=============");
        service.modify(set);
        return "redirect:/";
    }

    @RequestMapping(value = "/RemoveBoard", method = RequestMethod.POST)
    public String RemoveBoard(@RequestParam("bno") int bno) throws Exception{
        logger.info("============|BOARD REMOVE|=============");
        service.remove(bno);
        return "redirect:/";
    }

    @RequestMapping(value = "/ReBoard", method = RequestMethod.GET)
    public void ReBoardGET(int bno, SettingVO set, Model model) throws Exception{
        logger.info("=========|BOARD RE GET|==========");
        flag = 0;
        model.addAttribute(service.read(bno, flag));
        logger.info(set.toString());
    }

    @RequestMapping(value = "/ReBoard", method = RequestMethod.POST)
    public String ReBoardPOST(SettingVO set) throws Exception{
        logger.info("===========|BOARD RE POST|============");
        logger.info(set.toString());
        service.rewrite(set);
        return "redirect:/";
    }
}
