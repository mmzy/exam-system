package com.exam.mapper;

import com.exam.pojo.SubjectclassesExample;
import com.exam.pojo.SubjectclassesKey;
import com.exam.pojo.util.TeacherSubject;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectclassesMapper {
    int countByExample(SubjectclassesExample example);

    int deleteByExample(SubjectclassesExample example);

    int deleteByPrimaryKey(SubjectclassesKey key);

    int insert(SubjectclassesKey record);

    int insertSelective(SubjectclassesKey record);

    List<SubjectclassesKey> selectByExample(SubjectclassesExample example);

    int updateByExampleSelective(@Param("record") SubjectclassesKey record, @Param("example") SubjectclassesExample example);

    int updateByExample(@Param("record") SubjectclassesKey record, @Param("example") SubjectclassesExample example);

    List<TeacherSubject> getSubjectClassesTeacherList(int classesId);
    
    List<TeacherSubject> getSubjectClassesNotTeacherList(int classesId);
}