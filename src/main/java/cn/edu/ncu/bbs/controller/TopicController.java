package cn.edu.ncu.bbs.controller;


import cn.edu.ncu.bbs.domain.*;
import cn.edu.ncu.bbs.domain.security.MyToken;
import cn.edu.ncu.bbs.service.Impl.*;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private SubItemServiceImpl subItemService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        PageHelper.startPage(1,5);
        List<Topic> topics = topicService.findAllTopic();
//        PageInfo page = new PageInfo(topics);
        PageInfo<Topic> pageInfo=new PageInfo(topics);
        return pageInfo.toString();
    }


    //根据SubItemId查找对对应topic 默认page为1 pageSize=3
    //url:  /topic?subItemId=1&pageSize=1
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getSingleSubItem(@RequestParam int subItemId,
                                     @RequestParam(value = "pageNum",defaultValue="1") int pageNum,
                                     Model model){
        TopicExample topicExample =new TopicExample();
        TopicExample topicExample2 = new TopicExample();
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum,5);
        List<Topic> topics=topicService.findTopicBySubItemId(topicExample,subItemId);
        //将查询到的数据封装到PageInfo对象
        PageInfo<Topic> pageInfo=new PageInfo(topics);
        model.addAttribute("pageInfo",pageInfo);

        List<Topic> topTopics = topicService.findTopTopic(topicExample2,subItemId);
        SubItem subItem = subItemService.selectByPrimaryKey(String.valueOf(subItemId));
        MyToken user = null;
        if(SecurityContextHolder.getContext().getAuthentication() instanceof MyToken)
            user = (MyToken) SecurityContextHolder.getContext().getAuthentication();
        if (user != null)
        {
            if (user.getUserId().equals(subItem.getManager()) || user.containsRole("ROLE_ADMIN"))
            {
                List<Item> items = itemService.findAll();
                model.addAttribute("items",items);
                List<User> users = userService.findAll();
                model.addAttribute("users",users);
            }
        }

        //分割数据成功
        model.addAttribute("topics",topics);
        model.addAttribute("topTopics",topTopics);
        model.addAttribute("subItem",subItem);
        return "singleSubItem";
    }

    @RequestMapping(value = "/mytopic",method = RequestMethod.GET)
    public String myTopic( @RequestParam(value = "pageNum",defaultValue="1") int pageNum,Model model){
        TopicExample topicExample =new TopicExample();

        MyToken user = null;
        if(SecurityContextHolder.getContext().getAuthentication() instanceof MyToken)
            user = (MyToken) SecurityContextHolder.getContext().getAuthentication();
        if (user != null)
        {
            PageHelper.startPage(pageNum,5);
            List<Topic> topics=topicService.getTopicByUserId(topicExample,user.getUserId());
            //将查询到的数据封装到PageInfo对象
            PageInfo<Topic> pageInfo=new PageInfo(topics);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("topics",topics);

        }
        return "myTopic";
    }

    //显示所有文章
    @RequestMapping(value = "/alltopic",method = RequestMethod.GET)
    public String allTopic( @RequestParam(value = "pageNum",defaultValue="1") int pageNum,Model model){

            PageHelper.startPage(pageNum,10);
            List<Topic> topics=topicService.findAllTopic();
            //将查询到的数据封装到PageInfo对象
            PageInfo<Topic> pageInfo=new PageInfo(topics);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("topics",topics);

        return "allTopic";
    }


    //文章发布界面
    @RequestMapping(value = "/create/{id}")
    public String createPage(Model model,@PathVariable String id){
        SubItem subItem =  subItemService.selectByPrimaryKey(id);
        model.addAttribute(subItem);
        return "createTopic";
    }



    //发表文章
    @RequestMapping(value = "/createTopic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> createTopic(@RequestBody Topic topic){

        Map<String,Object> map = new HashMap<>();
        MyToken user = null;
        if(SecurityContextHolder.getContext().getAuthentication() instanceof MyToken)
            user = (MyToken) SecurityContextHolder.getContext().getAuthentication();

        if(user != null){
            topic.setManager(user.getUserId());
            topicService.createTopic(topic);
            userService.changeIntegral(user.getUserId(),topic.getIntegral());

        }
        map.put("result","OK");
        return map;

    }


    //返回对应id的文章
    @GetMapping("/{id}")
    public String getTopicById(@PathVariable int id, Model model){
        CommentExample commentExample =new CommentExample();
        SubCommentExample subCommentExample = new SubCommentExample();


        //通过id返回文章所有评论
        List<Comment> comments = commentService.getCommentByTopicId(commentExample, id);
        model.addAttribute("comments",comments);

        List<User> users = userService.findAll();
        model.addAttribute("users",users);

        //通过id加载文章
        Topic topic= topicService.getTopicById(id);
        model.addAttribute("topic",topic);

        SubItem subItem = subItemService.selectByPrimaryKey(String.valueOf(topic.getSubItemId()));
        model.addAttribute("subItem",subItem);

        //文章作者
        User user =userService.findById(String.valueOf(topic.getManager()));
        model.addAttribute("user",user);


        if(topic.getHelp())
        {
            return "helpTopic";
        }else {

            return "singleTopic";
        }
    }


    //返回修改文章界面
    @GetMapping("/update/{subItemId}/{id}")
    public String updateTopic(@PathVariable String subItemId ,@PathVariable int id,Model model){
        Topic topic= topicService.getTopicById(id);
        SubItem subItem = subItemService.selectByPrimaryKey(subItemId);
        model.addAttribute("topic",topic);
        model.addAttribute("subItem",subItem);
        return "updateTopic";
    }


    //修改文章内容
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateTopicById(@RequestBody Topic topic){

        Map<String,Object> map = new HashMap<>();
        topicService.updateTopic(topic);
        map.put("result","OK");
        return map;

    }

    @GetMapping("/delete/{subItemId}/{id}")
    public String deleteTopicById(@PathVariable int subItemId ,@PathVariable int id){
        topicService.deleteTopic(id);
        return "redirect:/topic?subItemId="+subItemId;

    }


    //通过id将文章置顶
    @GetMapping("/ontoppage/{subItemId}/{id}")
    public String onTopPageById(@PathVariable int subItemId ,@PathVariable int id){
        topicService.onTopPageById(id);
        return "redirect:/topic?subItemId="+subItemId;
    }
    //取消置顶
    @GetMapping("/outtoppage/{subItemId}/{id}")
    public String outTopPageById(@PathVariable int subItemId ,@PathVariable int id){
        topicService.outTopPageById(id);
        return "redirect:/topic?subItemId="+subItemId;
    }

    //通过id将文章加精
    @GetMapping("/elite/{subItemId}/{id}")
    public String EliteById(@PathVariable int subItemId,@PathVariable int id){
        topicService.eliteById(id);
        return "redirect:/topic?subItemId="+subItemId;
    }

    //取消加精
    @GetMapping("/outelite/{subItemId}/{id}")
    public String outEliteById(@PathVariable int subItemId,@PathVariable int id){
        topicService.outEliteById(id);
        return "redirect:/topic?subItemId="+subItemId;
    }

    //选择采纳回复
    @GetMapping("/adoptId/{topicId}/{adoptId}")
    public String adoptComment(@PathVariable int topicId,@PathVariable int adoptId){
        Topic topic = topicService.getTopicById(topicId);
        Comment comment = commentService.getCommentById(adoptId);
        topicService.chooseAdoptId(topicId,adoptId);
        userService.changeIntegral(comment.getCommentFrom(),-(topic.getIntegral()));
        return "redirect:/topic/"+topicId;
    }

    @GetMapping("/updateBrowse/{topicId}")
    @ResponseBody
    public Map<String,Object> updateBrowse(@PathVariable int topicId){
        Map<String,Object> map = new HashMap<>();
        Topic topic = topicService.getTopicById(topicId);
        int browse = topic.getBrowse()+1;
        topicService.updateBrowse(topicId,browse);
        map.put("result","OK");
        return map;
    }

}
