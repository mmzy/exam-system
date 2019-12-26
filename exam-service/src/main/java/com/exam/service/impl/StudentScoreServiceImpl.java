package com.exam.service.impl;

import org.springframework.stereotype.Service;

import com.exam.pojo.util.StudentScore;
import com.exam.service.StudentScoreService;
import com.github.pagehelper.PageInfo;

@Service
public class StudentScoreServiceImpl implements StudentScoreService{

	@Override
	public StudentScore selectStudentScoreById(String id) {
		
		return null;
	}

	@Override
	public PageInfo<StudentScore> selectStudentScoreByName(String name) {
		
		return null;
	}

	@Override
	public PageInfo<StudentScore> selectStudentScoreByClasses(String classesName) {
		
		return null;
	}

}
