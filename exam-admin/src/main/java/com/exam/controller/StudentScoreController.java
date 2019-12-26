package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.pojo.Examhis;
import com.exam.service.ExamHisService;

@Controller
@RequestMapping("/studentScore")
public class StudentScoreController {
	
	@Autowired
	private ExamHisService examHisService;
	
	@RequestMapping("/list")
	public String showStudentScore(String id, Model model){

		List<Examhis> list = examHisService.selectStudentById(id);
		Examhis student = new Examhis();
		if (list != null && list.size() > 0){
			student = list.get(0);
			
		}
		if (list == null || list.size() == 0){
			list = null;
		}
		model.addAttribute("id", id);
		model.addAttribute("student", student);
		model.addAttribute("list", list);
		return "/studentScore/list";
	}
	
}
