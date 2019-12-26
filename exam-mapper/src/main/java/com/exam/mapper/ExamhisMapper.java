package com.exam.mapper;

import com.exam.pojo.Examhis;
import com.exam.pojo.ExamhisExample;
import com.exam.pojo.ExamhisKey;
import com.exam.pojo.Student;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamhisMapper {
    int countByExample(ExamhisExample example);

    int deleteByExample(ExamhisExample example);

    int deleteByPrimaryKey(ExamhisKey key);

    int insert(Examhis record);

    int insertSelective(Examhis record);

    List<Examhis> selectByExampleWithBLOBs(ExamhisExample example);

    List<Examhis> selectByExample(ExamhisExample example);

    Examhis selectByPrimaryKey(ExamhisKey key);

    int updateByExampleSelective(@Param("record") Examhis record, @Param("example") ExamhisExample example);

    int updateByExampleWithBLOBs(@Param("record") Examhis record, @Param("example") ExamhisExample example);

    int updateByExample(@Param("record") Examhis record, @Param("example") ExamhisExample example);

    int updateByPrimaryKeySelective(Examhis record);

    int updateByPrimaryKeyWithBLOBs(Examhis record);

    int updateByPrimaryKey(Examhis record);
    
    //按照学号查询学生成绩
    List<Examhis> selectStudentById(String id);
    
    //按照班级名查询班级学生成绩
    List<Examhis> selectClassesByClassesName(String name);
    //按照班级查询学生科目
    List<Examhis> selectSubjectByClassesName(String name);
    //按照班级查询学生信息
    List<Student> selectStudentByClassesName(String name);
}