package cn.edu.ncu.bbs.controller;


import cn.edu.ncu.bbs.domain.SubComment;
import cn.edu.ncu.bbs.domain.SubCommentExample;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.Impl.SubCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subComment")
public class SubCommentController {

    @Autowired
    private SubCommentServiceImpl subCommentService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String createSubComment(@RequestParam(value = "subCommentTo") int subCommentTo,
                                 @RequestParam(value = "content") String content,
                                 @RequestParam(value = "commentId") int commentId,
                                 @RequestParam(value = "topicId") int topicId
                                 ){
        SubComment subComment=new SubComment();
        MyToken user=null;
        if(SecurityContextHolder.getContext().getAuthentication() instanceof MyToken)
            user = (MyToken) SecurityContextHolder.getContext().getAuthentication();
        if(user != null){
        subComment.setCommentId(commentId);
        subComment.setSubCommentFrom(user.getUserId());
        subComment.setSubCommentTo(subCommentTo);
        subComment.setContent(content);}
        subCommentService.createSubComment(subComment);
        return "redirect:/topic/"+topicId;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public List<SubComment> getSubComment( @PathVariable int id){
        SubCommentExample subCommentExample = new SubCommentExample();
        return subCommentService.getSubComment(subCommentExample,id);
    }


    @GetMapping("/delete/{id}")
    public void deleteSubCommentById(@PathVariable int id){
        subCommentService.deleteSubComment(id);
    }



}
