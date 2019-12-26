package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Subject;
import com.exam.service.ChapterService;
import com.exam.service.SubjectService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

/**
 * 科目管理   对科目进行增删改查
 * @author 王冲
 *
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ChapterService chapterService;
	
	/**
	 * 分页查询科目，展示给页面
	 * @param curr
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String showSubject(Integer curr, Model model){
		
		if (curr == null){
			curr = 1;
		}
		
		PageInfo<Subject> pageInfo = subjectService.showList(curr, 5);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/subject/list";
	}
	
	/**
	 * 跳转到添加科目页面
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addSubjectView(){
		
		return "/subject/add";
	}
	
	/**
	 * 添加科目
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResult addSubject(Subject subject){
		
		//判断学科名称是否为空
		if (CommonUtils.isEmpty(subject.getName())){
			return AjaxResult.errorInstance("学科名称不能为空");
		}
		//判断学科名称是否存在
		if (subjectService.isExisted(subject)){
			return AjaxResult.errorInstance("学科名称不能重复");
		}
		//添加科目
		subjectService.insert(subject);
		return AjaxResult.successInstance("添加成功");
	}
	
	/*
	 * 跳转到修改页面 
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.GET)
	public String updateSubjectView(int id, Model model){
		
		Subject subject = subjectService.selectOne(id);
		model.addAttribute("subject", subject);
		return "/subject/update";
	}
	
	/**
	 * 修改科目
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateSubject(Subject subject){
		
		//判断学科名称是否为空
		if (CommonUtils.isEmpty(subject.getName())){
			return AjaxResult.errorInstance("学科名称不能为空");
		}
		//判断学科名称是否存在
		if (subjectService.isExisted(subject)){
			return AjaxResult.errorInstance("学科名称不能重复");
		}
		
		subjectService.update(subject);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteSubject(int id){
		
		if (!chapterService.isEmpty(id)){
			return AjaxResult.errorInstance("对不起,该课程中的篇章没有删除完,不能删除!");
		}
		subjectService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
