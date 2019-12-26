package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.SubjectclassesMapper;
import com.exam.mapper.TeacherClassesMapper;
import com.exam.pojo.SubjectclassesKey;
import com.exam.pojo.TeacherClassesKey;
import com.exam.pojo.SubjectclassesExample;
import com.exam.pojo.SubjectclassesExample.Criteria;
import com.exam.pojo.util.TeacherSubject;
import com.exam.service.SubjectClassesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SubjectClassesServiceImpl implements SubjectClassesService{
	
	@Autowired
	private SubjectclassesMapper subjectClassesMapper;
	@Autowired
	private TeacherClassesMapper teacherClassesMapper;
	
	@Override
	public PageInfo<TeacherSubject> getSubjectClassesTeacherList(int pageNum, int pageSize, Integer classesId) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<TeacherSubject> list = subjectClassesMapper.getSubjectClassesTeacherList(classesId);
		return new PageInfo<TeacherSubject>(list);
	}

	@Override
	public PageInfo<TeacherSubject> getSubjectClassesNotTeacherList(int pageNum, int pageSize, Integer classesId) {
		PageHelper.startPage(pageNum, pageSize);
		List<TeacherSubject> list = subjectClassesMapper.getSubjectClassesNotTeacherList(classesId);
		return new PageInfo<TeacherSubject>(list);
	}

	@Override
	public void addTeacherSubject(Integer subId, Integer classesId, String teacherId) {
		
		//为subjectclasses表添加数据   将科目加入班级  
		SubjectclassesKey record = new SubjectclassesKey();
		record.setId(subId);
		record.setClassesid(classesId);
		subjectClassesMapper.insert(record);
		
		//为teacher_classes表添加数据   将老师加入到班级
		TeacherClassesKey teacherClasses = new TeacherClassesKey();
		teacherClasses.setId(teacherId);
		teacherClasses.setSubid(subId);
		teacherClasses.setClassesid(classesId);
		teacherClassesMapper.insert(teacherClasses);
		
	}

	@Override
	public void deleteTeacherSubject(Integer subId, Integer classesId, String teacherId) {
		//将subjectclasses表数据移除
		SubjectclassesKey record = new SubjectclassesKey();
		record.setId(subId);
		record.setClassesid(classesId);
		subjectClassesMapper.deleteByPrimaryKey(record);
		
		//将teacher_classes表数据移除
		TeacherClassesKey teacherClasses = new TeacherClassesKey();
		teacherClasses.setId(teacherId);
		teacherClasses.setSubid(subId);
		teacherClasses.setClassesid(classesId);
		teacherClassesMapper.deleteByPrimaryKey(teacherClasses);
	}

	@Override
	public boolean isEmpty(int classesId) {
		
		SubjectclassesExample example = new SubjectclassesExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesId);
		List<SubjectclassesKey> list = subjectClassesMapper.selectByExample(example);
		if (list == null || list.size() < 1){
			return true;
		}
		return false;
	}

}
