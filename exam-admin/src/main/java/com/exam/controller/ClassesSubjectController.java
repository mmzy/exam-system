package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.util.TeacherSubject;
import com.exam.service.SubjectClassesService;
import com.exam.util.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/classesSubject")
public class ClassesSubjectController {
	
	@Autowired
	private SubjectClassesService subjectClassesService;
	
	
	@RequestMapping("/update")
	public String updateClassesSubject(Integer curr, Integer classesId, Model model){
		if (curr == null){
			curr = 1;
		}
		PageInfo<TeacherSubject> pageInfo = subjectClassesService.getSubjectClassesTeacherList(curr, 5, classesId);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("classesId", classesId);
		return "/classesSubject/update";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addClassesSubjectView(Integer curr, Integer classesId, Model model){
		if (curr == null){
			curr = 1;
		}
		PageInfo<TeacherSubject> pageInfo = subjectClassesService.getSubjectClassesNotTeacherList(curr, 5, classesId);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("classesId", classesId);
		return "/classesSubject/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addClassesSubject(Integer subId, Integer classesId, String teacherId){
		subjectClassesService.addTeacherSubject(subId, classesId, teacherId);
		return AjaxResult.successInstance("添加成功");
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public AjaxResult deleteClassesSubject(Integer subId, Integer classesId, String teacherId){

		subjectClassesService.deleteTeacherSubject(subId, classesId, teacherId);
		return AjaxResult.successInstance("移除成功");
	}
	
}
