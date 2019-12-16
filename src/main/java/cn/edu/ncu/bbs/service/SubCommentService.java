package cn.edu.ncu.bbs.service;

import cn.edu.ncu.bbs.domain.SubComment;
import cn.edu.ncu.bbs.domain.SubCommentExample;

import java.util.List;

public interface SubCommentService {
    List<SubComment> getAllSubComment(SubCommentExample subCommentExample, List<Integer> commentIds );

    void deleteSubComment(int id);

    void createSubComment(SubComment subComment);
}
