package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Teacher;
import com.exam.service.TeacherService;
import com.exam.util.AjaxResult;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/logout")
	public String userLogout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.setAttribute("teacherInfo", null);
		return "redirect:/adminUser/login";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String userLogin(){
		
		return "/adminUser/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(String id, String password,Model model, HttpServletRequest request){
		
		Teacher teacher = teacherService.login(id, password);
		if (teacher != null){
			HttpSession session = request.getSession();
			session.setAttribute("teacherInfo", teacher);
			return "redirect:/index";
		}
		model.addAttribute("message", "用户名或密码错误!");
		return "/adminUser/login";
	}
	
	
	

	
	@RequestMapping(value="/updatePassword", method=RequestMethod.GET)
	public String userUpdatePasswordView(){
		
		return "/adminUser/updatePassword";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult userUpdatePassword(String id, String password, String newpassword, String renewpassword){
		
		if (newpassword != null){
			if (newpassword.equals(renewpassword)){
				boolean flag = teacherService.updatePassword(id, password, newpassword);
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
