package cn.edu.ncu.bbs.mapper;

import cn.edu.ncu.bbs.domain.Subitem;
import cn.edu.ncu.bbs.domain.SubitemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubitemMapper {
    int countByExample(SubitemExample example);

    int deleteByExample(SubitemExample example);

    int deleteByPrimaryKey(Integer subItemId);

    int insert(Subitem record);

    int insertSelective(Subitem record);

    List<Subitem> selectByExample(SubitemExample example);

    Subitem selectByPrimaryKey(Integer subItemId);

    int updateByExampleSelective(@Param("record") Subitem record, @Param("example") SubitemExample example);

    int updateByExample(@Param("record") Subitem record, @Param("example") SubitemExample example);

    int updateByPrimaryKeySelective(Subitem record);

    int updateByPrimaryKey(Subitem record);
}