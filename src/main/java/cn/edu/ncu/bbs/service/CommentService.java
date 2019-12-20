package cn.edu.ncu.bbs.service;


import cn.edu.ncu.bbs.domain.Comment;
import cn.edu.ncu.bbs.domain.CommentExample;

import java.util.List;

public interface CommentService {
    Comment getCommentById(int commentId);

    void createComment(Comment comment);
    List<Comment> getCommentByTopicId(CommentExample commentExample, int id);
    void deleteCommentById(int id);
}
