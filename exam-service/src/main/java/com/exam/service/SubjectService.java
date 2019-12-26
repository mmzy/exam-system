package com.exam.service;

import java.util.List;

import com.exam.pojo.Subject;
import com.github.pagehelper.PageInfo;

public interface SubjectService {
	
	//分页查询科目
	PageInfo<Subject> showList(int pageNum, int pageSize);
	//查询所有科目
	List<Subject> showList(String id);
	List<Subject> showList();
	//判断是否有重名的科目
	boolean isExisted(Subject subject);
	//插入科目
	void insert(Subject subject);
	//修改科目
	void update(Subject subject);
	//根据主键查询科目
	Subject selectOne(int id);
	//删除科目
	void delete(int id);
}
