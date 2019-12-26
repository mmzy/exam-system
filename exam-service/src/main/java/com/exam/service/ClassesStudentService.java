package com.exam.service;

import com.exam.pojo.Student;
import com.github.pagehelper.PageInfo;

public interface ClassesStudentService {
	
	/**
	 * 分页查询该班级所有学生集合集合
	 * @param pageNum
	 * @param pageSize
	 * @param id
	 * @return
	 */
	PageInfo<Student> getClassesStudentList(int pageNum, int pageSize, Integer id);
	
	/**
	 * 分页查询该老师未教科目集合
	 */
	PageInfo<Student> getNotClassesStudentList(int pageNum, int pageSize, Integer id);
	
	/**
	 * 向班级添加学生  即向该学生中加入classesId
	 */
	void insertClassesStudent(String id, Integer classesId);
	
	/**
	 * 将学生移除班级    实际上就是清空学生表中的classesId
	 * @param id
	 */
	void deleteStudent(String id);
	
	//根据班级id查询学生人数是否为空
	boolean isEmpty(int classesId);
	
	
}
