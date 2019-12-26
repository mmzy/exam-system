package com.exam.mapper;

import com.exam.pojo.Publishexam;
import com.exam.pojo.PublishexamExample;
import com.exam.pojo.PublishexamWithBLOBs;
import com.exam.pojo.Text;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishexamMapper {
    int countByExample(PublishexamExample example);

    int deleteByExample(PublishexamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PublishexamWithBLOBs record);

    int insertSelective(PublishexamWithBLOBs record);

    List<PublishexamWithBLOBs> selectByExampleWithBLOBs(PublishexamExample example);

    List<Publishexam> selectByExample(PublishexamExample example);

    PublishexamWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PublishexamWithBLOBs record, @Param("example") PublishexamExample example);

    int updateByExampleWithBLOBs(@Param("record") PublishexamWithBLOBs record, @Param("example") PublishexamExample example);

    int updateByExample(@Param("record") Publishexam record, @Param("example") PublishexamExample example);

    int updateByPrimaryKeySelective(PublishexamWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PublishexamWithBLOBs record);

    int updateByPrimaryKey(Publishexam record);
    
    
    List<Text> selectRandomText(int textModelId,int subjectId, int num);
}