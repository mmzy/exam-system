package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.ClassesMapper;
import com.exam.mapper.StudentMapper;
import com.exam.pojo.Classes;
import com.exam.pojo.Student;
import com.exam.pojo.StudentExample;
import com.exam.pojo.StudentExample.Criteria;
import com.exam.service.ClassesStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ClassesStudentServiceImpl implements ClassesStudentService{

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	
	@Override
	public PageInfo<Student> getClassesStudentList(int pageNum, int pageSize, Integer id) {
		
		PageHelper.startPage(pageNum, pageSize);
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(id);
		List<Student> list = studentMapper.selectByExample(example);
		
		return new PageInfo<Student>(list);
	}

	@Override
	public PageInfo<Student> getNotClassesStudentList(int pageNum, int pageSize, Integer id) {
		PageHelper.startPage(pageNum, pageSize);
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassesidIsNull();
		List<Student> list = studentMapper.selectByExample(example);
		
		return new PageInfo<Student>(list);
	}

	@Override
	public void deleteStudent(String id) {
		
		Student student = studentMapper.selectByPrimaryKey(id);
		student.setClassesid(null);
		student.setClassesname(null);
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		studentMapper.updateByExample(student, example);
	}

	@Override
	public void insertClassesStudent(String id, Integer classesId) {
		Student student = studentMapper.selectByPrimaryKey(id);
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		student.setClassesid(classesId);
		student.setClassesname(classes.getClassesname());
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		studentMapper.updateByExample(student, example);

	}

	@Override
	public boolean isEmpty(int classesId) {
		
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesId);
		List<Student> list = studentMapper.selectByExample(example);
		if (list == null || list.size() < 1){
			return true;
		}
		return false;
	}

}
