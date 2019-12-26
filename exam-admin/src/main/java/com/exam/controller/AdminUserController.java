package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Admin;
import com.exam.pojo.Student;
import com.exam.pojo.Teacher;
import com.exam.service.AdminService;
import com.exam.service.StudentService;
import com.exam.service.TeacherService;
import com.exam.util.AjaxResult;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/studentList")
	public String showStudent(Integer curr, Model model){
		
		if (curr == null){
			curr = 1;
		}
		
		PageInfo<Student> pageInfo = studentService.showList(curr, 5, null);
		model.addAttribute("pageInfo", pageInfo);
		return "/adminUser/studentList";
	}
	
	@RequestMapping("/teacherList")
	public String showTeacher(Integer curr, Model model){
		
		if (curr == null){
			curr = 1;
		}
		
		PageInfo<Teacher> pageInfo = teacherService.showList(curr, 5, null);
		model.addAttribute("pageInfo", pageInfo);
		return "/adminUser/teacherList";
	}
	
	@RequestMapping("/logout")
	public String userLogout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.setAttribute("adminInfo", null);
		return "redirect:/adminUser/login";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String userLogin(){
		
		return "/adminUser/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(String id, String password,Model model, HttpServletRequest request){
		
		Admin admin = adminService.login(id, password);
		if (admin != null){
			HttpSession session = request.getSession();
			session.setAttribute("adminInfo", admin);
			return "redirect:/index";
		}
		model.addAttribute("message", "用户名或密码错误!");
		return "/adminUser/login";
	}
	
	@RequestMapping(value="/resetTeacherPassword",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult teacherResetPassword(String id){
		
		if (!CommonUtils.isEmpty(id)){
			Teacher teacher = teacherService.selectOne(id);
			teacher.setPassword("111111");
			teacherService.update(teacher);
			return AjaxResult.successInstance("重置密码成功");
		}
		return AjaxResult.errorInstance("重置密码失败");
		
	}
	
	@RequestMapping(value="/resetStudentPassword",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult studentResetPassword(String id){
		
		if (!CommonUtils.isEmpty(id)){
			Student student = studentService.selectOne(id);
			student.setPassword("111111");
			studentService.update(student);
			return AjaxResult.successInstance("重置密码成功");
		}
		return AjaxResult.errorInstance("重置密码失败");
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
				boolean flag = adminService.updatePassword(id, password, newpassword);
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
	
	@RequestMapping(value="/deleteTeacher",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteTeacher(String id){
		
		if (!CommonUtils.isEmpty(id)){
			teacherService.delete(id);
			return AjaxResult.successInstance("删除成功");
		}
		return AjaxResult.errorInstance("删除失败");
	}
	
	@RequestMapping(value="/deleteStudent",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteStudent(String id){
		
		if (!CommonUtils.isEmpty(id)){
			studentService.delete(id);	
			return AjaxResult.successInstance("删除成功");
		}
		return AjaxResult.errorInstance("删除失败");
	}
	
}
