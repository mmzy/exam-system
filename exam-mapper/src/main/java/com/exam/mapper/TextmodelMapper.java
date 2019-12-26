package com.exam.mapper;

import com.exam.pojo.Textmodel;
import com.exam.pojo.TextmodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TextmodelMapper {
    int countByExample(TextmodelExample example);

    int deleteByExample(TextmodelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Textmodel record);

    int insertSelective(Textmodel record);

    List<Textmodel> selectByExample(TextmodelExample example);

    Textmodel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Textmodel record, @Param("example") TextmodelExample example);

    int updateByExample(@Param("record") Textmodel record, @Param("example") TextmodelExample example);

    int updateByPrimaryKeySelective(Textmodel record);

    int updateByPrimaryKey(Textmodel record);
}