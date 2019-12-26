package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Student;
import com.exam.service.ClassesStudentService;
import com.exam.util.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/classesStudent")
public class ClassesStudentController {
	
	@Autowired
	private ClassesStudentService classesStudentService;
	
	@RequestMapping("/update")
	public String updateClassesStudent(Integer curr, Integer id, Model model){
		
		if (curr == null){
			curr = 1;
		}
		PageInfo<Student> pageInfo = classesStudentService.getClassesStudentList(curr, 3, id);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/classesStudent/update";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addClassesStudentView(Integer curr, Integer id, Model model){
		
		if (curr == null){
			curr = 1;
		}
		PageInfo<Student> pageInfo = classesStudentService.getNotClassesStudentList(curr, 5, id);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/classesStudent/add";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addClassesStudent(String id, Integer classesId){
		
		classesStudentService.insertClassesStudent(id, classesId);
		return AjaxResult.successInstance("该学生已经加入班级");
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public AjaxResult deleteClassesStudent(String id){
		
		classesStudentService.deleteStudent(id);
		return AjaxResult.successInstance("该学生已从班级移除");
	}
}
