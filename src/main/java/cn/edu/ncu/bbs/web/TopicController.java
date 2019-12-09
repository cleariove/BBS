package cn.edu.ncu.bbs.web;


import cn.edu.ncu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topic/",method = RequestMethod.POST)
    public void createTopic(){


    }
}
