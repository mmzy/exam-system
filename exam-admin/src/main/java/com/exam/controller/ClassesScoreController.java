package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.pojo.Examhis;
import com.exam.pojo.Student;
import com.exam.service.ExamHisService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/classesScore")
public class ClassesScoreController {
	
	@Autowired
	private ExamHisService examhisService;
	
	@RequestMapping("/list")
	public String showStudentScore(Integer curr, String name, Model model){
		
		if (curr == null){
			curr = 1;
		}
		
		if (name == null){
			name = "";
		}
		
		try {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PageInfo<Student> studentInfo = examhisService.selectStudentByClassesName(curr, 1, name);
		List<Examhis> subjectList = examhisService.selectSubjectByClassesName(name);
		PageInfo<Examhis> scoreInfo = examhisService.selectClassesByClassesName(curr, 1*subjectList.size(), name);
		
		if (scoreInfo == null || scoreInfo.getList() == null || scoreInfo.getList().size() < 1){
			scoreInfo = null;
		}
		
		model.addAttribute("name", name);
		model.addAttribute("scoreInfo", scoreInfo);
		model.addAttribute("studentInfo", studentInfo);
		model.addAttribute("subjectList", subjectList);
		return "/classesScore/list";
	}
	
}
