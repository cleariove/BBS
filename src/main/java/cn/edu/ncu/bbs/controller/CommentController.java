package cn.edu.ncu.bbs.controller;

import cn.edu.ncu.bbs.domain.Comment;
import cn.edu.ncu.bbs.domain.CommentExample;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/comment"})
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("")
    @ResponseBody
    public Map<String,Object> CreateComment(@RequestBody Comment comment){
        Map<String,Object> map = new HashMap<>();
        MyToken user=(MyToken) SecurityContextHolder.getContext().getAuthentication();
        comment.setCommentFrom(user.getUserId());
        commentService.createComment(comment);
        map.put("result","OK");
        return map;



    }

    @GetMapping("/{id}")
    public void getCommentByTopicId(Model model, @PathVariable int id){
       CommentExample commentExample =new CommentExample();
       List<Comment> comments = commentService.getCommentByTopicId(commentExample,id);
       model.addAttribute("comments",comments);

    }

    @GetMapping("/delete")
    public String deleteCommentById(@RequestParam int commentId,@RequestParam int topicId){
        commentService.deleteCommentById(commentId);
        return "redirect:/topic/"+topicId;
    }
}
