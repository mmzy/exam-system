package com.exam.service;

import com.exam.pojo.util.TeacherSubject;
import com.github.pagehelper.PageInfo;

public interface SubjectClassesService {
	
	/**
	 * 查询班级中已拥有的老师科目集合
	 */
	PageInfo<TeacherSubject> getSubjectClassesTeacherList(int pageNum, int pageSize, Integer classesId);
	
	/**
	 * 查询班级中未拥有的老师科目集合
	 */
	PageInfo<TeacherSubject> getSubjectClassesNotTeacherList(int pageNum, int pageSize, Integer classesId);
	
	/**
	 * 添加指定老师的指定学科
	 */
	void addTeacherSubject(Integer subId, Integer classesId, String teacherId);
	
	
	/**
	 * 删除指定老师的指定学科
	 */
	void deleteTeacherSubject(Integer subId, Integer classesId, String teacherId);

	//根据班级id查询科目是否为空
	boolean isEmpty(int classesId);
}
