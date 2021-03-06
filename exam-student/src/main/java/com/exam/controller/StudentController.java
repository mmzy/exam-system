package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Student;
import com.exam.service.StudentService;
import com.exam.util.AjaxResult;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/logout")
	public String studentLogout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.setAttribute("studentInfo", null);
		return "redirect:/student/login";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String studentLogin(){
		
		return "/student/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(String id, String password,Model model, HttpServletRequest request){
		
		Student student = studentService.login(id, password);
		if (student != null){
			HttpSession session = request.getSession();
			session.setAttribute("studentInfo", student);
			return "redirect:/index";
		}
		model.addAttribute("message", "用户名或密码错误!");
		return "/student/login";
	}
	

	@RequestMapping(value="/updatePassword", method=RequestMethod.GET)
	public String studentUpdatePasswordView(){
		
		return "/student/updatePassword";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult studentUpdatePassword(String id, String password, String newpassword, String renewpassword){
		if (newpassword != null){
			if (newpassword.equals(renewpassword)){
				boolean flag = studentService.updatePassword(id, password, newpassword);
				if (flag){
					return AjaxResult.successInstance("修改密码成功");
				}else{
					return AjaxResult.errorInstance("原密码错误");
				}
			}else{
				return AjaxResult.errorInstance("您两次输入的密码不一致");
			}
		}
		
		return AjaxResult.errorInstance("您两次输入的密码不一致");
	}
	
	
}
