package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Student;
import com.exam.service.StudentService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String showStudent(Integer curr, Model model, String param){
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
		PageInfo<Student> pageInfo = studentService.showList(curr, 5, params);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/student/list";
	}
	
	/**
	 * 跳转到添加学生页面
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addStudentView(){
		
		return "/student/add";
	}
	
	/**
	 * 添加学生
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResult addStudent(Student student){
		
		//判断学生姓名是否为空
		if (CommonUtils.isEmpty(student.getId())){
			return AjaxResult.errorInstance("学生学号不能为空");
		}
		//判断学生姓名是否为空
		if (CommonUtils.isEmpty(student.getName())){
			return AjaxResult.errorInstance("学生姓名不能为空");
		}
		//判断学生性别是否为空
		if (CommonUtils.isEmpty(student.getSex())){
			return AjaxResult.errorInstance("学生性别不能为空");
		}
		//判断学生身份证号是否为空
		if (CommonUtils.isEmpty(student.getIdcard())){
			return AjaxResult.errorInstance("学生身份证号不能为空");
		}
		//判断身份证号是否已经存在
		if (studentService.isExisted(student.getIdcard())){
			return AjaxResult.errorInstance("该学生身份证号已经存在");
		}
		//判断学生手机号是否为空
		if (CommonUtils.isEmpty(student.getPhone())){
			return AjaxResult.errorInstance("学生手机号不能为空");
		}
		//判断手机号是否符合规范
		if (CommonUtils.isPhone(student.getPhone())){
			return AjaxResult.errorInstance("手机号不符合规范");
		}
		
		//判断邮箱是否符合规范
		if (!CommonUtils.isEmail(student.getEmail())){
			return AjaxResult.errorInstance("邮箱不符合规范");
		}
		//添加学生
		student.setPassword("111111");
		student.setStatus(1);
		studentService.insert(student);
		return AjaxResult.successInstance("添加成功");
	}
	
	
	@RequestMapping("/update")
	public String updateStudentView(String id, Model model){
		
		Student student = studentService.selectOne(id);
		model.addAttribute("student", student);
		
		return "/student/update";
	}
	
	/**
	 * 修改学生信息
	 * @param subject
	 * @return
	 */
	@RequestMapping(value = "/update",  method=RequestMethod.POST)
	public @ResponseBody AjaxResult updateStudent(Student student){
		
		Student oldStudent = studentService.selectOne(student.getId());
		
		//判断学生姓名是否为空
		if (CommonUtils.isEmpty(student.getId())){
			return AjaxResult.errorInstance("学生学号不能为空");
		}
		//判断学生姓名是否为空
		if (CommonUtils.isEmpty(student.getName())){
			return AjaxResult.errorInstance("学生姓名不能为空");
		}
		//判断学生性别是否为空
		if (CommonUtils.isEmpty(student.getSex())){
			return AjaxResult.errorInstance("学生性别不能为空");
		}
		//判断学生身份证号是否为空
		if (CommonUtils.isEmpty(student.getIdcard())){
			return AjaxResult.errorInstance("学生身份证号不能为空");
		}
		//判断身份证号是否已经存在
		if (!oldStudent.getIdcard().equals(student.getIdcard())){
			if (studentService.isExisted(student.getIdcard())){
				return AjaxResult.errorInstance("该学生身份证号已经存在");
			}
		}
		//判断学生手机号是否为空
		if (CommonUtils.isEmpty(student.getPhone())){
			return AjaxResult.errorInstance("学生手机号不能为空");
		}
		//判断手机号是否符合规范
		if (CommonUtils.isPhone(student.getPhone())){
			return AjaxResult.errorInstance("手机号不符合规范");
		}
		
		//判断邮箱是否符合规范
		if (!CommonUtils.isEmail(student.getEmail())){
			return AjaxResult.errorInstance("邮箱不符合规范");
		}
		student.setPassword(oldStudent.getPassword());
		student.setStatus(oldStudent.getStatus());
		studentService.update(student);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteStudent(String id){
		
		studentService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
}
