package com.exam.service;


import java.util.List;

import com.exam.pojo.Subject;
import com.github.pagehelper.PageInfo;

public interface TeacherSubjectService {
	
	/**
	 * 分页查询该老师所教科目集合
	 * @param pageNum
	 * @param pageSize
	 * @param id
	 * @return
	 */
	PageInfo<Subject> getSubjectList(int pageNum, int pageSize, String id);
	
	/**
	 * 获取老师所教的所有课程id
	 * @param id
	 * @return
	 */
	List<Integer> getTeacherAllSubjectId(String id);
	
	/**
	 * 分页查询该老师未教科目集合
	 */
	PageInfo<Subject> getTeacherNotSubjectList(int pageNum, int pageSize, String id);
	
	/**
	 * 移除该老师所教科目
	 * @param id
	 */
	void deleteSubject(Integer id, String tea_id);
	
	/**
	 * 为该老师添加一个学科
	 * @param id
	 * @param tea_id
	 */
	void addSubject(Integer id, String tea_id);
	
}
