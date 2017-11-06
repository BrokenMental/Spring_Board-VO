package com.setting.service;

import com.setting.domain.Criteria;
import com.setting.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    void addReply(ReplyVO vo);

    List<ReplyVO> listReply(Integer bno);

    void modifyReply(ReplyVO vo);

    void removeReply(Integer rno);

    List<ReplyVO> listReplyPage(Integer bno, Criteria cri);

    int count(Integer bno);
}
