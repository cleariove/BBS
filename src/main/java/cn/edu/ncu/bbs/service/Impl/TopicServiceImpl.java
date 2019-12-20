package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.ItemExample;
import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.TopicExample;
import cn.edu.ncu.bbs.mapper.TopicMapper;
import cn.edu.ncu.bbs.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<Topic> getTopicByUserId(TopicExample topicExample,int userId) {
        TopicExample.Criteria criteria =topicExample.createCriteria();
        criteria.andManagerEqualTo(userId);
        return topicMapper.selectByExample(topicExample);

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
    public void deleteTopic(int topicId) {
        topicMapper.deleteByPrimaryKey(topicId);
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
    public void onTopPageById(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setOnPageTop(true);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void outTopPageById(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setOnPageTop(false);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void eliteById(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setElite(true);
        topicMapper.updateByPrimaryKeySelective(topic);
    }
    @Override
    public void outEliteById(int topicId) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setElite(false);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void updateBrowse(int topicId,int browse) {
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setBrowse(browse);
        topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void chooseAdoptId(int topicId,int commentId){
        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setAdoptId(commentId);
        topicMapper.updateByPrimaryKeySelective(topic);
    }


//    @Override
//    public PageInfo<Topic> selectRoleList(Integer pageNum, Integer pageSize, Topic topic) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Topic> list = topicMapper.selectByExample(Topic);
//        PageInfo<Topic> pageInfo = new Topic<>(list);
//        return pageInfo;
//    }


}
