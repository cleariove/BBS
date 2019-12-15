package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.SubComment;
import cn.edu.ncu.bbs.domain.SubCommentExample;
import cn.edu.ncu.bbs.mapper.SubCommentMapper;
import cn.edu.ncu.bbs.service.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCommentServiceImpl implements SubCommentService {

    @Autowired
    private SubCommentMapper subCommentMapper;



    @Override
    public List<SubComment> getAllSubComment(SubCommentExample subCommentExample,List<Integer> commentIds ) {
        SubCommentExample.Criteria criteria = subCommentExample.createCriteria();
        criteria.andCommentIdIn(commentIds);
        return   subCommentMapper.selectByExample(subCommentExample);

    }

    @Override
    public void deleteSubComment(int id) {
        subCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void createSubComment(SubComment subComment) {
        subCommentMapper.insert(subComment);

    }
}
