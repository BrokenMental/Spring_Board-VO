package com.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setting.domain.Criteria;
import com.setting.domain.ReplyVO;
import com.setting.persistence.ReplyDAO;

@Service
public class ReplyService {

    @Autowired
    private ReplyDAO dao;

    public void addReply(ReplyVO vo) {
        dao.create(vo);
    }

    public List<ReplyVO> listReply(Integer bno) {
        return dao.list(bno);
    }

    public void modifyReply(ReplyVO vo) {
        dao.update(vo);
    }

    public void removeReply(Integer rno) {
        dao.delete(rno);
    }

    public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) {
        return dao.listPage(bno, cri);
    }

    public int count(Integer bno) {
        return dao.count(bno);
    }
}
