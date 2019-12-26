package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Teacher;
import com.exam.service.TeacherService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/list")
	public String showTeacher(Integer curr, String param, Model model){
		if (curr == null){
			curr = 1;
		}
		
		if (!CommonUtils.isEmpty(param)){
			try {
				param = new String(param.getBytes("iso-8859-1"),"utf-8");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			model.addAttribute("params", param);
			param = "%"+param+"%";
		}else{
			param = null;
		}
		
		Map<String,Object> params = new HashMap<>();
		params.put("param", param);
		PageInfo<Teacher> pageInfo = teacherService.showList(curr, 5, params);
		model.addAttribute("pageInfo", pageInfo);
		return "/teacher/list";
	}
	
	/**
	 * 跳转到添加教师页面
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addTeacherView(){
		
		return "/teacher/add";
	}
	
	/**
	 * 添加教师
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResult addTeacher(Teacher teacher){
		
		//判断教师姓名是否为空
		if (CommonUtils.isEmpty(teacher.getId())){
			return AjaxResult.errorInstance("教师学号不能为空");
		}
		//判断教师姓名是否为空
		if (CommonUtils.isEmpty(teacher.getName())){
			return AjaxResult.errorInstance("教师姓名不能为空");
		}
		//判断教师性别是否为空
		if (CommonUtils.isEmpty(teacher.getSex())){
			return AjaxResult.errorInstance("教师性别不能为空");
		}
		//判断教师身份证号是否为空
		if (CommonUtils.isEmpty(teacher.getIdcard())){
			return AjaxResult.errorInstance("教师身份证号不能为空");
		}
		//判断身份证号是否已经存在
		if (teacherService.isExisted(teacher.getIdcard())){
			return AjaxResult.errorInstance("该教师身份证号已经存在");
		}
		//判断教师手机号是否为空
		if (CommonUtils.isEmpty(teacher.getPhone())){
			return AjaxResult.errorInstance("教师手机号不能为空");
		}
		//判断手机号是否符合规范
		if (CommonUtils.isPhone(teacher.getPhone())){
			return AjaxResult.errorInstance("手机号不符合规范");
		}
		
		//判断邮箱是否符合规范
		if (!CommonUtils.isEmail(teacher.getEmail())){
			return AjaxResult.errorInstance("邮箱不符合规范");
		}
		//添加教师
		teacher.setPassword("111111");
		teacher.setStatus(1);
		teacherService.insert(teacher);
		return AjaxResult.successInstance("添加成功");
	}
	
	
	@RequestMapping("/update")
	public String updateTeacherView(String id, Model model){
		
		Teacher teacher = teacherService.selectOne(id);
		model.addAttribute("teacher", teacher);
		
		return "/teacher/update";
	}
	
	/**
	 * 修改教师信息
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateTeacher(Teacher teacher){
		
		Teacher oldteacher = teacherService.selectOne(teacher.getId());
		
		//判断教师姓名是否为空
		if (CommonUtils.isEmpty(teacher.getId())){
			return AjaxResult.errorInstance("教师教工号不能为空");
		}
		//判断教师姓名是否为空
		if (CommonUtils.isEmpty(teacher.getName())){
			return AjaxResult.errorInstance("教师姓名不能为空");
		}
		//判断教师性别是否为空
		if (CommonUtils.isEmpty(teacher.getSex())){
			return AjaxResult.errorInstance("教师性别不能为空");
		}
		//判断教师身份证号是否为空
		if (CommonUtils.isEmpty(teacher.getIdcard())){
			return AjaxResult.errorInstance("教师身份证号不能为空");
		}
		//判断身份证号是否已经存在
		if (!oldteacher.getIdcard().equals(teacher.getIdcard())){
			if (teacherService.isExisted(teacher.getIdcard())){
				return AjaxResult.errorInstance("该教师身份证号已经存在");
			}
		}
		//判断教师手机号是否为空
		if (CommonUtils.isEmpty(teacher.getPhone())){
			return AjaxResult.errorInstance("教师手机号不能为空");
		}
		//判断手机号是否符合规范
		if (CommonUtils.isPhone(teacher.getPhone())){
			return AjaxResult.errorInstance("手机号不符合规范");
		}
		
		//判断邮箱是否符合规范
		if (!CommonUtils.isEmail(teacher.getEmail())){
			return AjaxResult.errorInstance("邮箱不符合规范");
		}
		teacher.setPassword(oldteacher.getPassword());
		teacher.setStatus(oldteacher.getStatus());
		teacherService.update(teacher);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteTeacher(String id){
		
		teacherService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
