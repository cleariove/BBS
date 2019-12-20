package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Comment;
import cn.edu.ncu.bbs.domain.CommentExample;
import cn.edu.ncu.bbs.mapper.CommentMapper;
import cn.edu.ncu.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

@Override
    public  Comment getCommentById(int commentId){
        return commentMapper.selectByPrimaryKey(commentId);
    }
    @Override
    public void createComment(Comment comment) {
        commentMapper.insert(comment);

    }

    @Override
    public List<Comment> getCommentByTopicId(CommentExample commentExample,int id) {
        CommentExample.Criteria criteria =commentExample.createCriteria();
        criteria.andTopicIdEqualTo(id);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public void deleteCommentById(int id) {
        commentMapper.deleteByPrimaryKey(id);
    }
}
