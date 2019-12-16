package cn.edu.ncu.bbs.controller;


import cn.edu.ncu.bbs.domain.*;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.Impl.CommentServiceImpl;
import cn.edu.ncu.bbs.service.Impl.SubCommentServiceImpl;
import cn.edu.ncu.bbs.service.Impl.TopicServiceImpl;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/topic"})
public class TopicController {

    @Autowired
    private TopicServiceImpl topicService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private SubCommentServiceImpl subCommentService;

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }


    //根据SubItemId查找对对应topic 默认page为1 pageSize=3
    //url:  /topic?subItemId=1&pageSize=1
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getSomePerson(@RequestParam int subItemId,
                                     @RequestParam(value = "pageNum",defaultValue="1") int pageNum,
                                     Model model){
        TopicExample topicExample =new TopicExample();
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum,3);
        List<Topic> topics=topicService.findTopicBySubItemId(topicExample,subItemId);
        List<Topic> topTopics = topicService.findTopTopic(topicExample);
        System.out.println(topTopics);
        //将查询到的数据封装到PageInfo对象
        //PageInfo<Topic> pageInfo=new PageInfo(list,3);
        //分割数据成功
        model.addAttribute("topics",topics);
        model.addAttribute("topTopics",topTopics);
        return "page-categories-single";
    }

    //显示所有文章
    @RequestMapping(value = "/")
    public String topic(Model model){
        TopicExample topicExample =new TopicExample();

        List<Topic> topics = topicService.findAllTopic(topicExample);   //全部文章
        List<Topic> topTopics = topicService.findTopTopic(topicExample); //置顶文章
        model.addAttribute("topics",topics);
        model.addAttribute("topTopics",topTopics);
        return "page-categories-single";
    }

    //文章发布界面
    @RequestMapping(value = "/create")
    public String createPage(){
        return "page-create-topic";
    }



    //发表文章
    @RequestMapping(value = "/createTopic",method = RequestMethod.POST)
    @ResponseBody
    public String createTopic(@RequestBody Topic topic){

        MyToken user=(MyToken) SecurityContextHolder.getContext().getAuthentication();

        topic.setManager(user.getUserId());
        topic.setIntegral(user.getIntegral()+10);
        topicService.createTopic(topic);
        return "page-categories-single";

    }


    //返回对应id的文章
    @GetMapping("/{id}")
    public String getTopicById(@PathVariable int id, Model model){
        CommentExample commentExample =new CommentExample();
        SubCommentExample subCommentExample = new SubCommentExample();


        //通过id返回文章所有评论
        List<Comment> comments = commentService.getCommentByTopicId(commentExample,id);
        model.addAttribute("comments",comments);

        //通过commentId找出对应子评论
        List<Integer> commentIds = comments.stream().map(Comment::getCommentId).collect(Collectors.toList());
        List<SubComment> subComments = subCommentService.getAllSubComment(subCommentExample,commentIds);
        model.addAttribute("subComments",subComments);

        //通过id加载文章
        Topic topic= topicService.getTopicById(id);
        model.addAttribute("topic",topic);


        return "page-single-topic";
    }


    //返回修改文章界面
    @GetMapping("/update/{id}")
    public String updateTopic(@PathVariable int id,Model model){
        Topic topic= topicService.getTopicById(id);
        model.addAttribute("topic",topic);
        return "page-update-topic";
    }


    //修改文章内容
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateTopicById(@RequestBody Topic topic){
        System.out.println();
        topicService.updateTopic(topic);
        return "修改成功";

    }

    @GetMapping("/delete/{id}")
    public void deleteTopicById(@PathVariable int id){
        topicService.deleteTopic(id);
    }


    //通过id将文章置顶
    @GetMapping("/ontoppage/{id}")
    public String onTopPageById(@PathVariable int id){
        topicService.onTopPageById(id);
        return "文章已置顶";
    }

    //通过id将文章加精
    @GetMapping("/elite/{id}")
    public void eliteById(@PathVariable int id){
        topicService.eliteById(id);
    }


}
