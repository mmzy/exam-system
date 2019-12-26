package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.SubjectMapper;
import com.exam.mapper.TeacherSubjectMapper;
import com.exam.pojo.Subject;
import com.exam.pojo.SubjectExample;
import com.exam.pojo.TeacherSubjectExample;
import com.exam.pojo.TeacherSubjectKey;
import com.exam.pojo.SubjectExample.Criteria;
import com.exam.service.SubjectService;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 科目管理Service 
 * @author 王冲
 *
 */
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private TeacherSubjectMapper teacherSubjectMapper;
	
	@Override
	public PageInfo<Subject> showList(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		SubjectExample example = new SubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		
		List<Subject> list = subjectMapper.selectByExample(example);
		
		return new PageInfo<Subject>(list);
	}

	@Override
	public boolean isExisted(Subject subject) {
		
		SubjectExample example = new SubjectExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andNameEqualTo(subject.getName());
		List<Subject> list = subjectMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}

	@Override
	public void insert(Subject subject) {

		subjectMapper.insert(subject);
		
	}

	@Override
	public void update(Subject subject) {
		
		subjectMapper.updateByPrimaryKey(subject);
	}

	@Override
	public Subject selectOne(int id) {

		Subject subject = subjectMapper.selectByPrimaryKey(id);
		return subject;
	}

	@Override
	public void delete(int id) {
		subjectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Subject> showList() {

		SubjectExample example = new SubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		
		List<Subject> list = subjectMapper.selectByExample(example);
		
		return list;
	}
	
	@Override
	public List<Subject> showList(String id) {
		TeacherSubjectExample example1 = new TeacherSubjectExample();
		com.exam.pojo.TeacherSubjectExample.Criteria criteria2 = example1.createCriteria();
		criteria2.andIdEqualTo(id);
		List<TeacherSubjectKey> list2 = teacherSubjectMapper.selectByExample(example1);
		List<Integer> subjectIdList = new ArrayList<Integer>();
		for (TeacherSubjectKey key : list2) {
			subjectIdList.add(key.getSubId());
		}
		
		SubjectExample example = new SubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(subjectIdList);
		
		List<Subject> list = subjectMapper.selectByExample(example);
		
		return list;
	}
	
}
