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
import com.exam.pojo.Student;
import com.exam.pojo.Text;
import com.exam.pojo.Textmodel;
import com.exam.pojo.util.Exam;
import com.exam.pojo.util.ExamList;
import com.exam.pojo.util.TextModel;
import com.exam.service.ExamHisService;
import com.exam.service.PublishExamService;
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
	private TextModelService textModelService;
	@Autowired
	private TextService textService;
	@Autowired
	private ExamHisService examhisService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/list")
	public String showExam(HttpServletRequest request,Integer curr, Model model){
		if (curr == null){
			curr = 1;
		}
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("studentInfo");
		Integer classesid = student.getClassesid();
		if (classesid != null){
			PageInfo<Publishexam> publishexamList = publishExamService.selectAll(classesid, curr, 5);
			model.addAttribute("publishexamList", publishexamList);
		}
		model.addAttribute("studentInfo", student);
		return "/exam/list";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/exam")
	public String exam(HttpServletRequest request,int id,Model model){
		
		//0表示0.5小时，1表示1小时，2表示1.5小时，3表示2小时，4表示2.5小时，5表示3小时
		//考试时间所对应的毫秒数
		long[] dateLong = {30*60*1000, 60*60*1000, 90*60*1000, 120*60*1000, 150*60*1000, 180*60*1000};
		
		PublishexamWithBLOBs publishexam = publishExamService.selectByKey(id);
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("studentInfo");
		
		Examhis examhis = examhisService.studentIsNotExam(student.getId(), publishexam.getSubjectId(), publishexam.getExamtime());
		List<Text> textList = null;
		ArrayList<TextModel> list = JsonUtils.toBean(publishexam.getExam(), ArrayList.class, TextModel.class);
		Date date = new Date();
		Date date2 = new Date();
		date2.setTime(publishexam.getExamtime().getTime() + dateLong[publishexam.getExamlength()]);
		//当前时间如果在考试时间之前,考试还未开始
		if (date.compareTo(publishexam.getExamtime()) <= 0){
			model.addAttribute("message", "对不起当前考试还未开始!");
			return "/message";
		}
		
		/*1.当前时间>考试时间+考试时长，考试已经结束
		  2.examhis=null，则证明作者第一次点击开始考试
			如果examhis不为空
				状态为1:表示正在考试
				状态为2:表示已经考试结束，
				状态为3:表示老师已经阅完试卷
		*/
		if (date.compareTo(date2) >= 0 || (examhis != null && examhis.getStatus() != 1)){
			model.addAttribute("message", "对不起当前考试已经结束!");
			return "/message";
		}
		if (examhis == null){
			examhis = new Examhis();
			examhis.setStudentid(student.getId());
			examhis.setStudentname(student.getName());
			examhis.setSubjectid(publishexam.getSubjectId());
			examhis.setSubjectname(publishexam.getSubjectName());
			examhis.setClassesid(student.getClassesid());
			examhis.setClassesname(student.getClassesname());
			examhis.setPublishexamid(id);
			examhis.setExamtime(publishexam.getExamtime());
			examhis.setStatus(1);		
			textList = new ArrayList<Text>();		
			for (TextModel textModel : list) {
				List<Text> text = textService.beginExam(textModel,publishexam.getSubjectId());
				for (Text text2 : text) {
					text2.setTexId(textModel.getTextModelId());
				}
				textList.addAll(text);
			}
			String json = JsonUtils.toJson(textList);
			examhis.setExamtest(json);
			examhisService.insert(examhis);
		}else{
			textList = JsonUtils.toBean(examhis.getExamtest(), ArrayList.class, Text.class);
		}
		
		int sum = 0;
		for (TextModel textModel : list) {
			sum += textModel.getGrade()*textModel.getTextCount();
		}
		List<Textmodel> textModelList = textModelService.selectTextModel(list);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("studentInfo", student);
		model.addAttribute("textList", textList);
		model.addAttribute("publishexam", publishexam);
		model.addAttribute("sum", sum);
		model.addAttribute("examTimeLength", dateLong[publishexam.getExamlength()]/1000);
		model.addAttribute("examTime", (date2.getTime() - date.getTime())/1000);
		return "/exam/exam";
	}
	
	@RequestMapping(value="/examEnd", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult examEnd(HttpServletRequest request, ExamList examList, int id){
		
		PublishexamWithBLOBs publishexam = publishExamService.selectByKey(id);
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("studentInfo");
		
		Examhis examhis = examhisService.studentIsNotExam(student.getId(), publishexam.getSubjectId(), publishexam.getExamtime());
		List<Exam> list = examList.getExamList();
		list.remove(0);
		for (Exam exam : list) {
			exam.setText(textService.selectOne(exam.getTextId()));
			if (exam.getAnswer() == null){
				exam.setAnswer(" ");
			}
		}
		String json = JsonUtils.toJson(list);
		examhis.setExamtest(json);
		examhis.setStatus(2);
		examhisService.update(examhis);
		return AjaxResult.successInstance("您已成功提交考试");
	}

}
