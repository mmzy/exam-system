package com.exam.service;

import java.util.Map;

import com.exam.pojo.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {
	
	//分页查询学生信息
	PageInfo<Student> showList(int pageNum, int pageSize, Map<String, Object> params);
	//插入学生
	void insert(Student student);
	//修改学生
	void update(Student student);
	//根据主键查询学生
	Student selectOne(String id);
	//删除学生
	void delete(String id);
	//判断身份证号是否重复
	boolean isExisted(String idcard);
	boolean updatePassword(String id, String password, String newpassword);
	Student login(String id, String password);
}
