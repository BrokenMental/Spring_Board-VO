package com.setting.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String ID = "id";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();

        ModelMap modelMap = modelAndView.getModelMap(); // LoginPost 에서 model.addAttribute 로 넘긴 값을 받아오기 위해 getModelMap 을 사용.
        Object userID = modelMap.get("userID");

        if(userID != null){
            logger.info("new login success");
            session.setAttribute(ID, userID);
            request.setAttribute("flag", "yes");
            //response.sendRedirect("/Board/ListBoard");
        }else{
            logger.info("This ID or PW does not exist");
            request.setAttribute("flag", "no");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session.getAttribute(ID) != null){
            logger.info("clear login data before");
            session.removeAttribute(ID);
        }

        return true;
    }
}
