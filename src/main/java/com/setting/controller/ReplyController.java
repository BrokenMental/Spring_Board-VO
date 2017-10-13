package com.setting.controller;

import com.setting.domain.ReplyVO;
import com.setting.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ReplyVO vo){
        ResponseEntity<String> entity = null;
        try{
            service.addReply(vo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}
