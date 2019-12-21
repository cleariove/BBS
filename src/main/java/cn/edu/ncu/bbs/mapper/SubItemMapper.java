package cn.edu.ncu.bbs.mapper;

import cn.edu.ncu.bbs.domain.SubItem;
import cn.edu.ncu.bbs.domain.SubItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SubItemMapper {
    int countByExample(SubItemExample example);

    int deleteByExample(SubItemExample example);

    int deleteByPrimaryKey(Integer subItemId);

    int insert(SubItem record);

    int insertSelective(SubItem record);

    List<SubItem> selectByExample(SubItemExample example);

    SubItem selectByPrimaryKey(Integer subItemId);

    int updateByExampleSelective(@Param("record") SubItem record, @Param("example") SubItemExample example);

    int updateByExample(@Param("record") SubItem record, @Param("example") SubItemExample example);

    int updateByPrimaryKeySelective(SubItem record);

    int updateByPrimaryKey(SubItem record);
}