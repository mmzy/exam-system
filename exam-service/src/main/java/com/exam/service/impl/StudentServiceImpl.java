package com.exam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.StudentMapper;
import com.exam.pojo.Student;
import com.exam.pojo.StudentExample;
import com.exam.pojo.StudentExample.Criteria;
import com.exam.service.StudentService;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学生管理Service 
 * @author 王冲
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Student> showList(int pageNum, int pageSize, Map<String, Object> params) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Student> list = studentMapper.selectStudent(params);
		
		return new PageInfo<Student>(list);
	}

	@Override
	public void insert(Student student) {
		student.setPassword("111111");
		student.setStatus(0);
		studentMapper.insert(student);
		
	}

	@Override
	public void update(Student student) {
		
		studentMapper.updateByPrimaryKey(student);
	}

	@Override
	public Student selectOne(String id) {

		Student student = studentMapper.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public void delete(String id) {
		studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean isExisted(String idcard) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andIdcardEqualTo(idcard);
		List<Student> list = studentMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePassword(String id, String password, String newpassword) {
		Student student = studentMapper.selectByPrimaryKey(id);
		if (student != null){
			if (student.getPassword().equals(password)){
				student.setPassword(newpassword);
				StudentExample example = new StudentExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(id);
				studentMapper.updateByExample(student, example);
				return true;
			}
		}
		return false;
	}

	@Override
	public Student login(String id, String password) {
		Student student = studentMapper.selectByPrimaryKey(id);
		
		if (student != null){
			if (student.getPassword().equals(password)){
				return student;
			}
		}
		
		return null;
	}
	
}
