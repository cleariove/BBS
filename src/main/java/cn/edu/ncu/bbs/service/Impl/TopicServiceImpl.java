package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.TopicExample;
import cn.edu.ncu.bbs.mapper.TopicMapper;
import cn.edu.ncu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("TopicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;


    @Override
    public void insertTopic(Topic topic) {
        topicMapper.insert(topic);
    }
}
