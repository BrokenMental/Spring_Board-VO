package com.setting.persistence;

import com.setting.domain.Criteria;
import com.setting.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    List<ReplyVO> list(Integer bno);

    void create(ReplyVO vo);
    void update(ReplyVO vo);
    void delete(Integer rno);

    List<ReplyVO> listPage(Integer bno, Criteria cri);
    int count(Integer bno);
}
