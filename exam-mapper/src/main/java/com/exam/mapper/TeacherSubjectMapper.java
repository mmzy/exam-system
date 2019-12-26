package com.exam.mapper;

import com.exam.pojo.Subject;
import com.exam.pojo.TeacherSubjectExample;
import com.exam.pojo.TeacherSubjectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherSubjectMapper {
    int countByExample(TeacherSubjectExample example);

    int deleteByExample(TeacherSubjectExample example);

    int deleteByPrimaryKey(TeacherSubjectKey key);

    int insert(TeacherSubjectKey record);

    int insertSelective(TeacherSubjectKey record);

    List<TeacherSubjectKey> selectByExample(TeacherSubjectExample example);

    int updateByExampleSelective(@Param("record") TeacherSubjectKey record, @Param("example") TeacherSubjectExample example);

    int updateByExample(@Param("record") TeacherSubjectKey record, @Param("example") TeacherSubjectExample example);
    
    /**
     * 获取该教师所拥有的学科
     * @param id
     * @return
     */
    List<Subject> getSubjectList(String id);
    
    /**
     * 获取该教师未拥有的学科
     * @param id
     * @return
     */
    List<Subject> getTeacherNotSubjectList(String id);
    
}