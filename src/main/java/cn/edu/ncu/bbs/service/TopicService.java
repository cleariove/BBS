package cn.edu.ncu.bbs.service;

import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.TopicExample;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TopicService {

    //创建文章
    void createTopic(Topic topic);

    //通过 id 获取文章
    Topic getTopicById(int id);

    //更新文章
    void updateTopic(Topic topic);

    //删除文章
    void deleteTopic(int id);

    List<Topic> findAllTopic(TopicExample topicExample);

    List<Topic> findTopTopic(TopicExample topicExample,int id);

    List<Topic> findTopicBySubItemId(TopicExample topicExample,int id);

    void onTopPageById(int id);

    void outTopPageById(int id);

    void outEliteById(int id);

    void eliteById(int id);

    void updateBrowse(int id,int browse);

    //PageInfo<Topic> selectRoleList(Integer pageNum, Integer pageSize, Topic topic);
}
