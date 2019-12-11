package cn.edu.ncu.bbs.mapper;

import cn.edu.ncu.bbs.domain.SubComment;
import cn.edu.ncu.bbs.domain.SubCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubCommentMapper {
    int countByExample(SubCommentExample example);

    int deleteByExample(SubCommentExample example);

    int deleteByPrimaryKey(Integer subCommentId);

    int insert(SubComment record);

    int insertSelective(SubComment record);

    List<SubComment> selectByExample(SubCommentExample example);

    SubComment selectByPrimaryKey(Integer subCommentId);

    int updateByExampleSelective(@Param("record") SubComment record, @Param("example") SubCommentExample example);

    int updateByExample(@Param("record") SubComment record, @Param("example") SubCommentExample example);

    int updateByPrimaryKeySelective(SubComment record);

    int updateByPrimaryKey(SubComment record);
}