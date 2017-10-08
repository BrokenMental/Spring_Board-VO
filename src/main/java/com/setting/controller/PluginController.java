package com.setting.controller;

import com.setting.domain.LoginDTO;
import com.setting.domain.UserVO;
import com.setting.service.PluginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Plugin")
public class PluginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PluginService service;

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public void loginGET(@ModelAttribute("dto") LoginDTO dto){
        logger.info("Login Page");

    }

    @RequestMapping(value = "/LoginPost", method = RequestMethod.POST)
    public void loginPOST(LoginDTO dto, HttpSession session, Model model){
        logger.info("Login Post");
        UserVO vo = service.login(dto);

        if(vo == null){
            return;
        }

        model.addAttribute("userVO", vo);
    }

}
