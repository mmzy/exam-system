package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Textmodel;
import com.exam.service.TextModelService;
import com.exam.util.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/textModel")
public class TextModelController {
	
	@Autowired
	private TextModelService textModelService;
	
	@RequestMapping("/list")
	public String showTextModel(Integer curr, Model model){
		
		if (curr == null){
			curr = 1;
		}
		PageInfo<Textmodel> pageInfo = textModelService.showList(curr, 3);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/textModel/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addTextModelView(){
		
		return "/textModel/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addTextModel(Textmodel textmodel){
		
		if (textModelService.isExisted(textmodel)){
			return AjaxResult.errorInstance("试题模块名称已存在");
		}
		textModelService.insert(textmodel);
		return AjaxResult.successInstance("添加成功");
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateTextModelView(int id, Model model){
		
		Textmodel textmodel = textModelService.selectOne(id);
		model.addAttribute("textmodel", textmodel);
		return "/textModel/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateTextModel(Textmodel textmodel){
		
		if (textModelService.isExisted(textmodel)){
			return AjaxResult.errorInstance("试题模块名称已存在");
		}
		textModelService.update(textmodel);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteTextModel(int id){
		
		textModelService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
