package cn.edu.ncu.bbs.controller;


import cn.edu.ncu.bbs.domain.SubComment;
import cn.edu.ncu.bbs.service.Impl.SubCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubCommentController {

    @Autowired
    private SubCommentServiceImpl subCommentService;

    @RequestMapping(value = "/subComment",method = RequestMethod.POST)
    @ResponseBody
    public void createSubComment(@RequestBody SubComment subComment){
        subCommentService.createSubComment(subComment);
    }


    @GetMapping("/subComment/delete/{id}")
    public void deleteSubCommentById(@PathVariable int id){
        subCommentService.deleteSubComment(id);
    }



}
