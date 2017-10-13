package com.setting.service;

import com.setting.domain.ReplyVO;
import com.setting.persistence.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDAO dao;

    @Override
    public void addReply(ReplyVO vo){
        dao.create(vo);
    }

    @Override
    public List<ReplyVO> listReply(Integer bno){
        return dao.list(bno);
    }

    @Override
    public void modifyReply(ReplyVO vo){
        dao.update(vo);
    }

    @Override
    public void removeReply(Integer rno){
        dao.delete(rno);
    }
}
