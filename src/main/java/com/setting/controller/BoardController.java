package com.setting.controller;

import com.setting.domain.PageMaker;
import com.setting.domain.SearchCriteria;
import com.setting.domain.SettingVO;
import com.setting.domain.UserVO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.messaging.simp.stomp.StompHeaders.ID;

/**
 * Created by Jinuk on 2017-07-17.
 */
@Controller
@RequestMapping(value = "/Board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //static String session_id;
    int flag = 0; // 멀티스레드 환경이 되면 좋지않다. 바꿔주자.

    @Autowired
    PluginService servicePlug;
    @Autowired
    SettingService serviceSet;

    @RequestMapping(value = "/ListBoard", method = RequestMethod.GET)
    public void ListBoardGET(@ModelAttribute("cri") SearchCriteria cri,/* @ModelAttribute("id") String id,*/ Model model){
        logger.info("===============|BOARD LIST|===============");
        //logger.info(id);
        //session_id = id;
        //model.addAttribute("id", id); //@ModelAttribute("") 를 사용하면 이 문장을 사용하지 않아도 모델로 전달한다.
        logger.info(cri.toString());
        model.addAttribute("list", servicePlug.listSearchCriteria(cri));

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(servicePlug.listSearchCount(cri));

        model.addAttribute("pageMaker", pageMaker);
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.GET)
    public void NewBoardGET(){
        logger.info("===============|BOARD NEW GET|===============");
        //return "Board/NewBoard"; // void가 아닌 다른 타입으로 반환형을 선언할 경우 필요
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.POST)
    public String NewBoardPOST(SettingVO set, HttpServletRequest request){
        HttpSession session = request.getSession();

        logger.info("==============|BOARD NEW POST|===============");
        logger.info(set.toString());
        //erviceSet.write(set, ((UserVO) session.getAttribute(ID)).getId()); // 예전에는 Map 형식으로 ID와 PW를 동시에 받았지만 이번에는 ID만 session.set 하기 때문에 (UserVO)변환이 필요없다.
        serviceSet.write(set, (String)session.getAttribute(ID)); // session object 형식으로 받으니까 String 형으로 변환시켜준다.
        return "redirect:/Board/ListBoard";  // redirect 가 없을경우 form 에 action 페이지가 정해져 있지 않기 때문인지 몰라도 페이지는 이동되지만 url 은 board/newboard 로 남아있다.
    }

    @RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
    public void ReadBoardGET(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model){
        logger.info("==============|BOARD READ|===============");
        flag = 1;
        model.addAttribute(serviceSet.read(bno, flag));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
    public void ModifyBoardGET(int bno, Model model){
        logger.info("============|BOARD MODIFY GET|=============");
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
    public void ReBoardGET(int bno, Model model){
        logger.info("=========|BOARD RE GET|==========");
        flag = 0;
        model.addAttribute(serviceSet.read(bno, flag));
    }

    @RequestMapping(value = "/ReBoard", method = RequestMethod.POST)
    public String ReBoardPOST(SettingVO set, HttpServletRequest request){
        HttpSession session = request.getSession();

        logger.info("===========|BOARD RE POST|============");
        logger.info(set.toString());
        serviceSet.rewrite(set, (String)session.getAttribute(ID));
        return "redirect:/Board/ListBoard";
    }
}
