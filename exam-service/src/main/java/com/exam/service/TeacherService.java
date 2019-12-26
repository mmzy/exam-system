package com.exam.service;

import java.util.Map;

import com.exam.pojo.Teacher;
import com.github.pagehelper.PageInfo;

public interface TeacherService {
	
	//分页查询学生信息
	PageInfo<Teacher> showList(int pageNum, int pageSize, Map<String, Object> params);
	//插入学生
	void insert(Teacher teacher);
	//修改学生
	void update(Teacher teacher);
	//根据主键查询学生
	Teacher selectOne(String id);
	//删除学生
	void delete(String id);
	//判断身份证号是否重复
	boolean isExisted(String idcard);
	Teacher login(String id, String password);
	boolean updatePassword(String id, String password, String newpassword);
}
