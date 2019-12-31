package com.exam.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.exam.mapper.PublishexamMapper;
import com.exam.pojo.*;
import com.exam.service.PublishExamService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.exam.mapper.ExamhisMapper;
import com.exam.pojo.ExamhisExample.Criteria;
import com.exam.service.ExamHisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.PostConstruct;

@Service
public class ExamHisServiceImpl implements ExamHisService{
	
	@Autowired
	private ExamhisMapper examhisMapper;
	@Autowired
	private PublishexamMapper publishexamMapper;

    private static ConcurrentLinkedQueue<Examhis> examHisQuery = new ConcurrentLinkedQueue<Examhis>();


    public static ConcurrentLinkedQueue<Examhis> getExamHisQuery(){
        return ExamHisServiceImpl.examHisQuery;
    }

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

	public void MarkingExam(Examhis examhis,ApplicationContext context){

        PublishexamWithBLOBs publishexamWithBLOBs =  ((PublishexamMapper)(context.getBean("publishexamMapper")))
                .selectByPrimaryKey
                (examhis
                .getPublishexamid());

        String exams = publishexamWithBLOBs.getExam();
        JSONArray examsArray = JSONArray.parseArray(exams);
        Map<Integer,Integer> examsGrade = new HashMap<>();
        for (int i=0;i<examsArray.size();i++){
            JSONObject json = examsArray.getJSONObject(i);
            examsGrade.put(json.getInteger("textModelId"),json.getInteger("grade")/json.getInteger("textCount"));
        }

        String text = examhis.getExamtest();
        JSONArray jsonArray = JSONArray.parseArray(text);
        Map<Integer,Integer>  textObject  = new HashMap<>();
        int score = 0;
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = jsonArray.getJSONObject(i);
            String currentAnswer = json.getString("answer");
            JSONObject jsonText = json.getJSONObject("text");
            String userAnswer = jsonText.getString("answer");
            if(currentAnswer!=null&&userAnswer!=null&&currentAnswer.trim()!=""&&currentAnswer.equals(userAnswer)){
                score = score + examsGrade.get(jsonText.getInteger("texId"));
            }
        }
        ExamhisKey examhisKey = new ExamhisKey();
        examhisKey.setStudentid(examhis.getStudentid());
        examhisKey.setSubjectid(examhis.getSubjectid());
        Examhis dataBaseExamhis = ((ExamhisMapper)(context.getBean("examhisMapper"))).selectByPrimaryKey(examhisKey);
        dataBaseExamhis.setScore(score);
        ((ExamhisMapper)(context.getBean("examhisMapper"))).updateByPrimaryKey(dataBaseExamhis);
    }
}
