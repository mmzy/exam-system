package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.TeacherSubjectMapper;
import com.exam.pojo.Subject;
import com.exam.pojo.TeacherSubjectExample;
import com.exam.pojo.TeacherSubjectExample.Criteria;
import com.exam.pojo.TeacherSubjectKey;
import com.exam.service.TeacherSubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService{

	@Autowired
	private TeacherSubjectMapper teacherSubjectMapper;
	/**
	 * 通过老师id获取老师所教科目集合
	 * @param id
	 * @return
	 */
	@Override
	public PageInfo<Subject> getSubjectList(int pageNum, int pageSize, String id){
		
		/*TeacherSubjectExample example = new TeacherSubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TeacherSubjectKey> list = teacherSubjectMapper.selectByExample(example);
		
		LinkedList<Subject> subjectList = new LinkedList<>();
		for (int i = 0; i < list.size(); i++){
			Integer subjectId = list.get(i).getSubId();
			Subject subject = subjectMapper.selectByPrimaryKey(subjectId);
			subjectList.add(subject);
		}*/
		
		PageHelper.startPage(pageNum, pageSize);
		List<Subject> list = teacherSubjectMapper.getSubjectList(id);
		
		return new PageInfo<Subject>(list);
		
	}
	
	@Override
	public PageInfo<Subject> getTeacherNotSubjectList(int pageNum, int pageSize, String id) {
		PageHelper.startPage(pageNum, pageSize);
		List<Subject> list = teacherSubjectMapper.getTeacherNotSubjectList(id);
		
		return new PageInfo<Subject>(list);
	}
	
	@Override
	public void deleteSubject(Integer id, String tea_id) {
		
		TeacherSubjectKey teacherSubject = new TeacherSubjectKey();
		teacherSubject.setId(tea_id);
		teacherSubject.setSubId(id);
		teacherSubjectMapper.deleteByPrimaryKey(teacherSubject);
		//teacherSubjectMapper.delete(teacherSubject);
		
	}

	@Override
	public void addSubject(Integer id, String tea_id) {
		
		TeacherSubjectKey key = new TeacherSubjectKey();
		key.setSubId(id);
		key.setId(tea_id);
		teacherSubjectMapper.insert(key);
	}

	@Override
	public List<Integer> getTeacherAllSubjectId(String id) {
		
		TeacherSubjectExample example = new TeacherSubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TeacherSubjectKey> list = teacherSubjectMapper.selectByExample(example);
		List<Integer> subjectIdList = new ArrayList<Integer>();
		for(TeacherSubjectKey tsk : list){
			subjectIdList.add(tsk.getSubId());
		}
		return subjectIdList;
	}
	
	
}
