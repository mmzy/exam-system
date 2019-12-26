package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Chapter;
import com.exam.service.ChapterService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/list")
	public String showChapter(Integer curr, Model model, int subjectId){
		
		if (curr == null){
			curr = 1;
		}
		
		PageInfo<Chapter> pageInfo = chapterService.showList(curr, 5, subjectId);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("subjectId", subjectId);
		return "/chapter/list";
	}
	
	/**
	 * 跳转到添加科目页面
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addChapterView(int id, Model model){
		int subjectId = id;
		model.addAttribute("subjectId", subjectId);
		return "/chapter/add";
	}
	
	/**
	 * 添加科目
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResult addChapter(Chapter chapter){
		
		//判断学科名称是否为空
		if (CommonUtils.isEmpty(chapter.getName())){
			return AjaxResult.errorInstance("篇章名称不能为空");
		}
		//判断篇章标题是否存在
		if (CommonUtils.isEmpty(chapter.getTitle())){
			return AjaxResult.errorInstance("篇章标题不能为空");
		}
		//添加科目
		chapterService.insert(chapter);
		return AjaxResult.successInstance("添加成功");
	}
	
	/*
	 * 跳转到修改页面 
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.GET)
	public String updateChapterView(int id, Model model){
		
		Chapter chapter = chapterService.selectOne(id);
		model.addAttribute("chapter", chapter);
		return "/chapter/update";
	}
	
	/**
	 * 修改科目
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateChapter(Chapter chapter){
		
		//判断学科名称是否为空
		if (CommonUtils.isEmpty(chapter.getName())){
			return AjaxResult.errorInstance("篇章名称不能为空");
		}
		//判断篇章标题是否存在
		if (CommonUtils.isEmpty(chapter.getTitle())){
			return AjaxResult.errorInstance("篇章标题不能为空");
		}
		
		chapterService.update(chapter);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteChapter(int id){
		
		chapterService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
