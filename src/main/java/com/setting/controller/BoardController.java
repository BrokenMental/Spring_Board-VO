package com.setting.controller;

import com.setting.domain.SettingVO;
import com.setting.service.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by Jinuk on 2017-07-17.
 */
@Controller
@RequestMapping(value = "/Board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    SettingService service;

    @RequestMapping(value = "/NewBoard", method = RequestMethod.GET)
    public void NewBoardGET() throws Exception{
        logger.info("=========================================");
        logger.info("===============|NEW BOARD|===============");
        logger.info("===============|BOARD GET|===============");
        logger.info("=========================================");

        //return "Board/NewBoard"; // void가 아닌 다른 타입으로 반환형을 선언할 경우 필요
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.POST)
    public String NewBoardPOST(SettingVO set) throws Exception{
        logger.info("=========================================");
        logger.info("===============|NEW BOARD|===============");
        logger.info("==============|BOARD POST|===============");
        logger.info("=========================================");

        service.Write(set);
        return "redirect:/";
    }
}
