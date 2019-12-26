package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.PublishexamMapper;
import com.exam.mapper.SubjectclassesMapper;
import com.exam.pojo.Publishexam;
import com.exam.pojo.PublishexamExample;
import com.exam.pojo.PublishexamExample.Criteria;
import com.exam.pojo.util.TextModel;
import com.exam.pojo.PublishexamWithBLOBs;
import com.exam.pojo.SubjectclassesExample;
import com.exam.pojo.SubjectclassesKey;
import com.exam.pojo.Text;
import com.exam.service.PublishExamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学生管理Service 
 * @author 王冲
 *
 */
@Service
public class PublishExamServiceImpl implements PublishExamService{

	@Autowired
	private PublishexamMapper publishexamMapper;
	@Autowired
	private SubjectclassesMapper subjectclassesMapper;
	
	@Override
	public PageInfo<Publishexam> selectAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PublishexamExample example = new PublishexamExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<Publishexam> list = publishexamMapper.selectByExample(example);
		return new PageInfo<Publishexam>(list);
	}

	@Override
	public void insert(PublishexamWithBLOBs publishExam) {
		publishexamMapper.insert(publishExam);
	}

	@Override
	public void update(PublishexamWithBLOBs publishExam) {
		publishexamMapper.updateByPrimaryKeyWithBLOBs(publishExam);
	}

	@Override
	public void delete(int id) {
		publishexamMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PublishexamWithBLOBs selectByKey(int id) {
		PublishexamWithBLOBs publishExam = publishexamMapper.selectByPrimaryKey(id);
		return publishExam;
	}

	@Override
	public PageInfo<Publishexam> selectAll(int id, int pageNum, int pageSize) {
		SubjectclassesExample example = new SubjectclassesExample();
		com.exam.pojo.SubjectclassesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(id);
		List<SubjectclassesKey> list = subjectclassesMapper.selectByExample(example);
		List<Integer> subjectIdList = new ArrayList<Integer>();
		for (SubjectclassesKey subjectclassesKey : list) {
			subjectIdList.add(subjectclassesKey.getId());
		}
		PageHelper.startPage(pageNum, pageSize);
		
		
		PublishexamExample example2 = new PublishexamExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andSubjectIdIn(subjectIdList);
		List<Publishexam> list2 = publishexamMapper.selectByExample(example2);
		return new PageInfo<Publishexam>(list2);
	}

	@Override
	public List<Text> beginExam(TextModel textModel, Integer subjectId) {
		
		List<Text> list = publishexamMapper.selectRandomText(textModel.getTextModelId(), subjectId, textModel.getTextCount());
		return list;
		
	}

	@Override
	public PageInfo<Publishexam> selectTeacherExam(List<Integer> subjectId,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PublishexamExample example = new PublishexamExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubjectIdIn(subjectId);
		List<Publishexam> list = publishexamMapper.selectByExample(example);
		return new PageInfo<Publishexam>(list);
	}
	

}
