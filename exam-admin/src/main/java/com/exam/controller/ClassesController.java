package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Classes;
import com.exam.service.ClassesService;
import com.exam.service.ClassesStudentService;
import com.exam.service.SubjectClassesService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService classesService;
	@Autowired
	private ClassesStudentService classesStudentService;
	@Autowired
	private SubjectClassesService subjectClassesService;
	
	/**
	 * 分页查询科目，展示给页面
	 * @param curr
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String showClasses(Integer curr, Model model){
		
		if (curr == null){
			curr = 1;
		}
		
		PageInfo<Classes> pageInfo = classesService.showList(curr, 5);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/classes/list";
	}
	
	/**
	 * 跳转到添加科目页面
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addClassesView(){
		
		return "/classes/add";
	}
	
	/**
	 * 添加班级
	 * @param classes
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResult addClasses(Classes classes){
		
		//判断班级名称是否为空
		if (CommonUtils.isEmpty(classes.getClassesname())){
			return AjaxResult.errorInstance("班级名称不能为空");
		}
		//判断所在年级是否为空
		if (CommonUtils.isEmpty(classes.getGrade())){
			return AjaxResult.errorInstance("班级所在年级不能为空");
		}
		//添加班级
		classesService.insert(classes);
		return AjaxResult.successInstance("添加成功");
	}
	
	/*
	 * 跳转到修改页面 
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.GET)
	public String updateClassesView(int id, Model model){
		
		Classes classes = classesService.selectOne(id);
		model.addAttribute("classes", classes);
		return "/classes/update";
	}
	
	/**
	 * 添加班级
	 * @param classes
	 * @return
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateClasses(Classes classes){
		
		//判断班级名称是否为空
		if (CommonUtils.isEmpty(classes.getClassesname())){
			return AjaxResult.errorInstance("班级名称不能为空");
		}
		//判断所在年级是否为空
		if (CommonUtils.isEmpty(classes.getGrade())){
			return AjaxResult.errorInstance("班级所在年级不能为空");
		}
		
		classesService.update(classes);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteClasses(int id){
		
		if (!classesStudentService.isEmpty(id)){
			return AjaxResult.errorInstance("对不起,班级中还有学生没有移除,不能删除班级");
		}
		if (!subjectClassesService.isEmpty(id)){
			return AjaxResult.errorInstance("对不起,班级中还有课程存在,不能删除班级");
		}
		classesService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
