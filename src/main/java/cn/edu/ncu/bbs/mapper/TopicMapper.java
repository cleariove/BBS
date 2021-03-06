package cn.edu.ncu.bbs.mapper;

import cn.edu.ncu.bbs.domain.Topic;
import cn.edu.ncu.bbs.domain.TopicExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TopicMapper {
    int countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int deleteByPrimaryKey(Integer topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(Integer topicId);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> getTopicByUserId(TopicExample topicExample,int userId);

    List<Topic> findByItemId(Integer itemId);

    //PageInfo<Topic> selectRoleList(Integer pageNum, Integer pageSize, Topic topic);
}