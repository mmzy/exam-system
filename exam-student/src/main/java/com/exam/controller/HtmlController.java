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
import com.exam.util.JsonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
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
	
	@RequestMapping("/home")
	public String showHome(HttpServletRequest request,Integer curr, Model model){
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
		return "/html/home";
	}
	
	@RequestMapping("/login")
	public String showLogin(HttpServletRequest request,Integer curr, Model model){
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
		return "/html/login";
	}
	
	@RequestMapping("/monitor")
	public String showMonitor(HttpServletRequest request,Integer curr, Model model){
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
		return "/html/monitor";
	}
	
	@RequestMapping("/rule")
	public String showRule(HttpServletRequest request,Integer curr, Model model){
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
		return "/html/rule";
	}
	
	@RequestMapping("/test")
	public String showTest(HttpServletRequest request,Integer curr, Model model){
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
		return "/html/test";
	}
	
}