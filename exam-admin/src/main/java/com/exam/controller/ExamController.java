package com.exam.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Admin;
import com.exam.pojo.Publishexam;
import com.exam.pojo.PublishexamWithBLOBs;
import com.exam.pojo.Subject;
import com.exam.pojo.Textmodel;
import com.exam.pojo.util.BeanTextModel;
import com.exam.pojo.util.TextModel;
import com.exam.service.PublishExamService;
import com.exam.service.SubjectService;
import com.exam.service.TextModelService;
import com.exam.util.AjaxResult;
import com.exam.util.JsonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/exam")
public class ExamController {
	

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TextModelService textModelService;
	@Autowired
	private PublishExamService publishExamService;
	
	/**
	 * 初始化时间类型
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * 显示考试信息列表
	 * @param curr
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String showExam(Integer curr, Model model){
		if (curr == null){
			curr = 1;
		}
		//查询出发布的开始信息列表
		PageInfo<Publishexam> publishexamList = publishExamService.selectAll(curr, 5);
		model.addAttribute("publishexamList", publishexamList);
		return "/exam/list";
	}
	
	/**
	 * 跳转到考试页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addExamView(Model model){
		
		//查询试题和试题模块列表，在前端页面上显示
		List<Subject> textList = subjectService.showList();
		List<Textmodel> textModelList = textModelService.showList();
		model.addAttribute("textList", textList);
		model.addAttribute("textModelList", textModelList);
		return "/exam/add";
	}
	
	/**
	 * 添加考试信息
	 * @param request
	 * @param publishExam
	 * @param textModelIds
	 * @param beanTextModel
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addExam(HttpServletRequest request,PublishexamWithBLOBs publishExam,int[] textModelIds, BeanTextModel beanTextModel){
		
		//添加考试信息，获取到是哪个管理员添加的考试信息
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("adminInfo");
		publishExam.setAdminId(admin.getId()); 
		publishExam.setAdminName(admin.getName());
		publishExam.setStatus(0);
		publishExam.setPublishtime(new Date());
		//查询出考试的科目
		Subject subject = subjectService.selectOne(publishExam.getSubjectId());
		publishExam.setSubjectName(subject.getName());
		//因为试题模块数量，题目数量，题目分值是一直变化的
		//存储在数据库中比较字段不好建立，因此我们将这块提取出一个TextModel类
		//将多个模块添加到List集合中转成JSON格式存储到数据库中
		List<TextModel> list = new ArrayList<TextModel>();
		if (textModelIds != null){
			for (int i : textModelIds) {
				for(TextModel textModel : beanTextModel.getListTextModel()){
					if (textModel.getTextModelId() != null && i == textModel.getTextModelId()){
						list.add(textModel);
					}
				}
			}
			String json = JsonUtils.toJson(list);
			publishExam.setExam(json);
		}
		publishExamService.insert(publishExam);
		
		return AjaxResult.successInstance("添加成功");
	}
	
	/**
	 * 跳转到发布考试页面
	 * @param id
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateExamView(int id, Model model){
		PublishexamWithBLOBs publishExam = publishExamService.selectByKey(id);
		//将存储的JSON取出并解析成Java对象
		ArrayList<TextModel> updateList = JsonUtils.toBean(publishExam.getExam(), ArrayList.class, TextModel.class);
		//获取科目列表
		List<Subject> textList = subjectService.showList();
		//获取试题模块列表
		List<Textmodel> textModelList = textModelService.showList();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(publishExam.getExamtime());
		model.addAttribute("date", date);
		model.addAttribute("textList", textList);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("updateList", updateList);
		model.addAttribute("publishExam", publishExam);
		return "/exam/update";
	}
	
	/**
	 * 修改所发布的考试
	 * @param request
	 * @param id
	 * @param publishExam
	 * @param textModelIds
	 * @param beanTextModel
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateExam(HttpServletRequest request,int id, PublishexamWithBLOBs publishExam,int[] textModelIds, BeanTextModel beanTextModel){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("adminInfo");
		publishExam.setAdminId(admin.getId()); 
		publishExam.setAdminName(admin.getName());
		publishExam.setStatus(0);
		publishExam.setPublishtime(new Date());
		Subject subject = subjectService.selectOne(publishExam.getSubjectId());
		publishExam.setSubjectName(subject.getName());
		List<TextModel> list = new ArrayList<TextModel>();
		if (textModelIds != null){
			for (int i : textModelIds) {
				for(TextModel textModel : beanTextModel.getListTextModel()){
					if (textModel.getTextModelId() != null && i == textModel.getTextModelId()){
						list.add(textModel);
					}
				}
			}
			String json = JsonUtils.toJson(list);
			publishExam.setExam(json);
		}
		publishExamService.update(publishExam);
		return AjaxResult.successInstance("修改成功");
	}
	
	/**
	 * 删除考试信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteExam(int id){
		publishExamService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}

}
