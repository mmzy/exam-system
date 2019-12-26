package com.exam.service;

import com.exam.pojo.util.StudentScore;
import com.github.pagehelper.PageInfo;

public interface StudentScoreService {
	
	//根据id查询学生成绩
	StudentScore selectStudentScoreById(String id);
	//根据姓名查找学生成绩
	PageInfo<StudentScore> selectStudentScoreByName(String name);
	//根据班级查询学生成绩
	PageInfo<StudentScore> selectStudentScoreByClasses(String classesName);
	
}
