package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.pojo.Examhis;
import com.exam.pojo.Student;
import com.exam.service.ExamHisService;

@Controller
@RequestMapping("/studentScore")
public class StudentScoreController {
	
	@Autowired
	private ExamHisService examHisService;
	
	@RequestMapping("/list")
	public String showStudentScore(HttpServletRequest request, Model model){

		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("studentInfo");
		List<Examhis> list = examHisService.selectStudentById(student.getId());
		if (list != null && list.size() > 0){
			Examhis studentExamHis = list.get(0);
			model.addAttribute("studentExamHis", studentExamHis);
		}
		if (list != null && list.size() == 0){
			list = null;
		}
		model.addAttribute("list", list);
		return "/studentScore/list";
	}
	
}
