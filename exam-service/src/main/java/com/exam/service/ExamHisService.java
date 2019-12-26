package com.exam.service;

import java.util.Date;
import java.util.List;

import com.exam.pojo.Examhis;
import com.exam.pojo.Student;
import com.github.pagehelper.PageInfo;

public interface ExamHisService {
	
	/**
	 * 根据学生id查询学生成绩
	 */
	List<Examhis> selectStudentById(String id);
	
	/**
	 * 根据班级名查询成绩
	 */
	PageInfo<Examhis> selectClassesByClassesName(int pageNum, int pageSize, String name);
	
	/**
	 * 根据班级名称查询科目
	 */
	List<Examhis> selectSubjectByClassesName(String name);
	
	/**
	 * 根据班级名称查询学生
	 */
	PageInfo<Student> selectStudentByClassesName(int pageNum, int pageSize, String name);
	
	void insert(Examhis examhis);
	
	void update(Examhis examhis);
	
	//考试中返回true，为考试返回false
	Examhis studentIsNotExam(String studentId, int subjectId, Date examTime);

	PageInfo<Examhis> selectExamStudent(int id, int pageNum, int pageSize, int status);

	Examhis selectByKey(String studentid, int publishexamid);
}
