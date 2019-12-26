package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Subject;
import com.exam.service.TeacherSubjectService;
import com.exam.util.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/teacherSubject")
public class TeacherSubjectController {
	
	@Autowired
	private TeacherSubjectService teacherSubjectService;
	
	@RequestMapping("update")
	public String showSubject(Integer curr, String id, Model model){
		if (curr == null){
			curr = 1;
		}
		PageInfo<Subject> pageInfo = teacherSubjectService.getSubjectList(curr, 3, id);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/teacherSubject/update";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String addSubjectView(Integer curr, String id, Model model){
		if (curr == null){
			curr = 1;
		}
		PageInfo<Subject> pageInfo = teacherSubjectService.getTeacherNotSubjectList(curr, 5, id);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("id", id);
		return "/teacherSubject/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addSubject(Integer id, String tea_id){
		teacherSubjectService.addSubject(id, tea_id);
		return AjaxResult.successInstance("添加成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public AjaxResult deleteSubject(Integer id, String tea_id){
		teacherSubjectService.deleteSubject(id, tea_id);
		return AjaxResult.successInstance("移除成功");
		
	}
	
}
