package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.ItemExample;
import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.TopicExample;
import cn.edu.ncu.bbs.mapper.TopicMapper;
import cn.edu.ncu.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {



    @Autowired
    private TopicMapper topicMapper;


    @Override
    public void createTopic(Topic topic) {
        topicMapper.insert(topic);
    }

    @Override
    public Topic getTopicById(int id) {
        return topicMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTopic(Topic topic) {
        Topic newTopic =new Topic();
        newTopic.setTitle(topic.getTitle());
        newTopic.setContent(topic.getContent());
        newTopic.setTopicId(topic.getTopicId());
        newTopic.setManager(topic.getManager());
       topicMapper.updateByPrimaryKeySelective(newTopic);
    }

    @Override
    public void deleteTopic(int id) {
        topicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Topic> findAllTopic(TopicExample topicExample) {
        return topicMapper.selectByExample(topicExample);
    }

    @Override
    public List<Topic> findTopTopic(TopicExample topicExample,int subItemId) {
        TopicExample.Criteria criteria =topicExample.createCriteria();
        criteria.andSubItemIdEqualTo(subItemId);
        criteria.andOnPageTopEqualTo(true);
        return topicMapper.selectByExample(topicExample);

    }

    @Override
    public List<Topic> findTopicBySubItemId(TopicExample topicExample,int subItemId) {
        TopicExample.Criteria criteria = topicExample.createCriteria();
        topicExample.setOrderByClause("date desc");
        criteria.andSubItemIdEqualTo(subItemId);
        criteria.andOnPageTopEqualTo(false);
        return topicMapper.selectByExample(topicExample);
    }

    @Override
    public void onTopPageById(int id) {
        Topic topic = new Topic();
        topic.setTopicId(id);
        topic.setOnPageTop(true);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void outTopPageById(int id) {
        Topic topic = new Topic();
        topic.setTopicId(id);
        topic.setOnPageTop(false);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void eliteById(int id) {
        Topic topic = new Topic();
        topic.setTopicId(id);
        topic.setElite(true);
        topicMapper.updateByPrimaryKeySelective(topic);
    }
    @Override
    public void outEliteById(int id) {
        Topic topic = new Topic();
        topic.setTopicId(id);
        topic.setElite(false);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

}
