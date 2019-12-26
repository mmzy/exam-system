package com.exam.service;

import java.util.List;

import com.exam.pojo.Publishexam;
import com.exam.pojo.PublishexamWithBLOBs;
import com.exam.pojo.Text;
import com.exam.pojo.util.TextModel;
import com.github.pagehelper.PageInfo;

public interface PublishExamService {
	
	/**
	 * 查询指定学生的考试信息
	 */
	PageInfo<Publishexam> selectAll(int id, int pageNum, int pageSize);	
	/**
	 * 查询所有考试信息
	 */
	PageInfo<Publishexam> selectAll(int pageNum, int pageSize);	
	//插入考试信息
	void insert(PublishexamWithBLOBs publishExam);
	//修改考试信息
	void update(PublishexamWithBLOBs publishExam);
	//根据主键删除考试信息
	void delete(int id);
	//根据主键查询考试信息
	PublishexamWithBLOBs selectByKey(int id);
	List<Text> beginExam(TextModel textModel, Integer subjectId);
	//查询老师所教课程的考试信息
	PageInfo<Publishexam> selectTeacherExam(List<Integer> subjectId,int pageNum,int pageSize);
}
