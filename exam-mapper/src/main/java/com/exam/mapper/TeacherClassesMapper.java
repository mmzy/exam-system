package com.exam.mapper;

import com.exam.pojo.TeacherClassesExample;
import com.exam.pojo.TeacherClassesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherClassesMapper {
    int countByExample(TeacherClassesExample example);

    int deleteByExample(TeacherClassesExample example);

    int deleteByPrimaryKey(TeacherClassesKey key);

    int insert(TeacherClassesKey record);

    int insertSelective(TeacherClassesKey record);

    List<TeacherClassesKey> selectByExample(TeacherClassesExample example);

    int updateByExampleSelective(@Param("record") TeacherClassesKey record, @Param("example") TeacherClassesExample example);

    int updateByExample(@Param("record") TeacherClassesKey record, @Param("example") TeacherClassesExample example);
}