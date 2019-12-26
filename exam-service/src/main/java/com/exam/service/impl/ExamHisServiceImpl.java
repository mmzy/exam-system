package com.exam.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.ExamhisMapper;
import com.exam.pojo.Examhis;
import com.exam.pojo.ExamhisExample;
import com.exam.pojo.ExamhisExample.Criteria;
import com.exam.pojo.ExamhisKey;
import com.exam.pojo.Student;
import com.exam.service.ExamHisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ExamHisServiceImpl implements ExamHisService {
	
	@Autowired
	private ExamhisMapper examhisMapper;
	

	@Override
	public List<Examhis> selectStudentById(String id) {
		
		List<Examhis> list = examhisMapper.selectStudentById(id);
		return list;
	}

	@Override
	public PageInfo<Examhis> selectClassesByClassesName(int pageNum, int pageSize, String name) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Examhis> list = examhisMapper.selectClassesByClassesName(name);
		
		return new PageInfo<Examhis>(list);
	}

	@Override
	public List<Examhis> selectSubjectByClassesName(String name) {
		
		List<Examhis> list = examhisMapper.selectSubjectByClassesName(name);
		return list;
	}

	@Override
	public PageInfo<Student> selectStudentByClassesName(int pageNum, int pageSize, String name) {
		PageHelper.startPage(pageNum, pageSize);
		List<Student> list = examhisMapper.selectStudentByClassesName(name);
		
		return new PageInfo<Student>(list);
	}

	@Override
	public Examhis studentIsNotExam(String studentId, int subjectId,Date examTime) {
		
		ExamhisKey key = new ExamhisKey();
		key.setExamtime(examTime);
		key.setStudentid(studentId);
		key.setSubjectid(subjectId);
		Examhis examhis = examhisMapper.selectByPrimaryKey(key);
		return examhis;
	}

	@Override
	public void insert(Examhis examhis) {
		examhisMapper.insert(examhis);
	}

	@Override
	public void update(Examhis examhis) {
		//examhisMapper.updateByPrimaryKey(examhis);
		examhisMapper.updateByPrimaryKeyWithBLOBs(examhis);
	}

	@Override
	public PageInfo<Examhis> selectExamStudent(int id,int pageNum, int pageSize, int status) {
		PageHelper.startPage(pageNum, pageSize);
		ExamhisExample example = new ExamhisExample();
		Criteria criteria = example.createCriteria();
		criteria.andPublishexamidEqualTo(id);
		criteria.andStatusEqualTo(status);
		List<Examhis> list = examhisMapper.selectByExample(example);
		return new PageInfo<Examhis>(list);
	}

	@Override
	public Examhis selectByKey(String studentid, int publishexamid) {
		
		ExamhisExample example = new ExamhisExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andPublishexamidEqualTo(publishexamid);
		List<Examhis> list = examhisMapper.selectByExampleWithBLOBs(example);
		return list.get(0);
	}
	
	

}
