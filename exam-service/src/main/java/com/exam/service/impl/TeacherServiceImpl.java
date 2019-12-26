package com.exam.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.TeacherMapper;
import com.exam.pojo.Teacher;
import com.exam.pojo.TeacherExample;
import com.exam.pojo.TeacherExample.Criteria;
import com.exam.service.TeacherService;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学生管理Service 
 * @author 王冲
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public PageInfo<Teacher> showList(int pageNum, int pageSize, Map<String, Object> params) {
		
		PageHelper.startPage(pageNum, pageSize);
	
		List<Teacher> list = teacherMapper.selectTeacher(params);
		
		return new PageInfo<Teacher>(list);
	}

	@Override
	public void insert(Teacher teacher) {
		
		teacher.setPassword("111111");
		teacher.setStatus(0);
		teacherMapper.insert(teacher);
		
	}

	@Override
	public void update(Teacher teacher) {
		
		teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public Teacher selectOne(String id) {

		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
		return teacher;
	}

	@Override
	public void delete(String id) {
		teacherMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean isExisted(String idcard) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andIdcardEqualTo(idcard);
		List<Teacher> list = teacherMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}

	@Override
	public Teacher login(String id, String password) {
		
		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
		
		if (teacher != null){
			if (teacher.getPassword().equals(password)){
				return teacher;
			}
		}
		
		return null;
	}

	@Override
	public boolean updatePassword(String id, String password, String newpassword) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
		if (teacher != null){
			if (teacher.getPassword().equals(password)){
				teacher.setPassword(newpassword);
				TeacherExample example = new TeacherExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(id);
				teacherMapper.updateByExample(teacher, example);
				return true;
			}
		}
		return false;
	}
	
}
