package com.exam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Examhis;
import com.exam.pojo.Publishexam;
import com.exam.pojo.PublishexamWithBLOBs;
import com.exam.pojo.Teacher;
import com.exam.pojo.Textmodel;
import com.exam.pojo.util.Exam;
import com.exam.pojo.util.ExamhisAnswer;
import com.exam.pojo.util.ExamhisAnswerList;
import com.exam.pojo.util.TextModel;
import com.exam.service.ExamHisService;
import com.exam.service.PublishExamService;
import com.exam.service.TeacherSubjectService;
import com.exam.service.TextModelService;
import com.exam.service.TextService;
import com.exam.util.AjaxResult;
import com.exam.util.JsonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private PublishExamService publishExamService;
	@Autowired
	private TeacherSubjectService teacherSubjectService;
	@Autowired
	private ExamHisService examhisService;
	@Autowired
	private TextModelService textModelService;
	@Autowired
	private TextService textService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/*
	 * 显示考试列表 
	 */
	@RequestMapping("/list")
	public String showExam(HttpServletRequest request, Integer curr, Model model){
		if (curr == null){
			curr = 1;
		}
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacherInfo");
		List<Integer> subjectId = teacherSubjectService.getTeacherAllSubjectId(teacher.getId());
		PageInfo<Publishexam> publishexamList = publishExamService.selectTeacherExam(subjectId,curr,5);
		model.addAttribute("publishexamList", publishexamList);
		return "/exam/list";
	}
	
	/*
	 * 显示未批阅试卷
	 */
	@RequestMapping(value="examStudent", method = RequestMethod.GET)
	public String showStudentExam(Integer id, Integer curr, Model model){
		if (curr == null){
			curr = 1;
		}
		if (id == null ){
			id = 0;
		}
		//查询未批阅学生
		PageInfo<Examhis> pageInfo = examhisService.selectExamStudent(id,curr,5,2);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/exam/studentList";
	}
	
	/*
	 * 显示已批阅试卷
	 */
	@RequestMapping(value="examStudent2", method = RequestMethod.GET)
	public String showStudentTest(Integer id, Integer curr, Model model){
		if (curr == null){
			curr = 1;
		}
		if (id == null ){
			id = 0;
		}
		//查询已批阅学生试卷
		PageInfo<Examhis> pageInfo = examhisService.selectExamStudent(id,curr,5,3);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/exam/studentList2";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="examtest", method = RequestMethod.GET)
	public String showExamTest(String studentid, int publishexamid, Model model){
		Examhis examhis = examhisService.selectByKey(studentid,publishexamid);
		List<Exam> list = JsonUtils.toBean(examhis.getExamtest(), ArrayList.class, Exam.class);
		PublishexamWithBLOBs publishexam = publishExamService.selectByKey(publishexamid);
		ArrayList<TextModel> TextModel = JsonUtils.toBean(publishexam.getExam(), ArrayList.class, TextModel.class);
		List<Textmodel> textModelList = textModelService.selectTextModel(TextModel);
		model.addAttribute("TextModel", TextModel);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("examhis", examhis);
		model.addAttribute("examList", list);
		return "/exam/examtest";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="studentTest", method = RequestMethod.GET)
	public String showStudentTest(String studentid, int publishexamid, Model model){
		Examhis examhis = examhisService.selectByKey(studentid,publishexamid);
		List<ExamhisAnswer> list = JsonUtils.toBean(examhis.getExamtest(), ArrayList.class, ExamhisAnswer.class);
		PublishexamWithBLOBs publishexam = publishExamService.selectByKey(publishexamid);
		ArrayList<TextModel> TextModel = JsonUtils.toBean(publishexam.getExam(), ArrayList.class, TextModel.class);
		List<Textmodel> textModelList = textModelService.selectTextModel(TextModel);
		model.addAttribute("TextModel", TextModel);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("examhis", examhis);
		model.addAttribute("ExamhisAnswer", list);
		return "/exam/studentTest";
	}
	
	@RequestMapping("/score")
	@ResponseBody
	public AjaxResult studentScore(ExamhisAnswerList examhisAnswerList,String studentid, int publishexamid){
		Examhis examhis = examhisService.selectByKey(studentid, publishexamid);
		List<ExamhisAnswer> list = examhisAnswerList.getExamhisAnswerList();
		list.remove(0);
		int sum = 0;
		for (ExamhisAnswer examhisAnswer : list) {
			if (examhisAnswer.getGrade() == null){
				examhisAnswer.setGrade(0);
			}
			sum += examhisAnswer.getGrade();
			examhisAnswer.setText(textService.selectOne(examhisAnswer.getTextId()));
			
		}
		String json = JsonUtils.toJson(list);
		examhis.setExamtest(json);
		examhis.setScore(sum);
		examhis.setStatus(3);
		examhisService.update(examhis);
		return AjaxResult.successInstance("阅卷成功");
	}
	
}
