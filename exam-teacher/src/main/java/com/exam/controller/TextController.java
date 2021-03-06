package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.pojo.Chapter;
import com.exam.pojo.Subject;
import com.exam.pojo.Teacher;
import com.exam.pojo.Text;
import com.exam.pojo.Textmodel;
import com.exam.service.ChapterService;
import com.exam.service.SubjectService;
import com.exam.service.TextModelService;
import com.exam.service.TextService;
import com.exam.util.AjaxResult;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/text")
public class TextController {
	
	@Autowired
	private TextService textService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TextModelService textModelService;
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/list")
	public String showText(HttpServletRequest request,Integer curr, Model model){
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacherInfo");
		
		if (curr == null){
			curr = 1;
		}
		PageInfo<Text> pageInfo = textService.showList(curr, 8, teacher.getId());
		model.addAttribute("pageInfo", pageInfo);
		
		return "/text/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addTextView(HttpServletRequest request,Model model){
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacherInfo");
		List<Subject> textList = subjectService.showList(teacher.getId());
		Subject subject = textList.get(0);
		List<Chapter> chapterList = chapterService.getChapter(subject.getId());
		List<Textmodel> textModelList = textModelService.showList();
		model.addAttribute("textList", textList);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("chapterList", chapterList);
		return "/text/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addText(Text text){
		
		Integer chapterid = text.getChapterid();
		Chapter chapter = chapterService.selectOne(chapterid);
		text.setChaptername(chapter.getName()+"   "+chapter.getTitle());
		
		Integer subjectid = text.getSubjectid();
		Subject subject = subjectService.selectOne(subjectid);
		text.setSubjectname(subject.getName());
		
		Integer texId = text.getTexId();
		Textmodel textmodel = textModelService.selectOne(texId);
		text.setModelname(textmodel.getTexttype());
		
		textService.insert(text);
		return AjaxResult.successInstance("添加成功");
	}
	
	@RequestMapping(value="/text")
	public String textTextView(HttpServletRequest request, int id, Model model){
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacherInfo");
		Text text = textService.selectOne(id);
		List<Chapter> chapterList = chapterService.getChapter(text.getSubjectid());
		List<Subject> textList = subjectService.showList(teacher.getId());
		List<Textmodel> textModelList = textModelService.showList();
		model.addAttribute("textList", textList);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("text", text);
		return "/text/text";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateTextView(HttpServletRequest request, int id, Model model){
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacherInfo");
		Text text = textService.selectOne(id);
		List<Chapter> chapterList = chapterService.getChapter(text.getSubjectid());
		List<Subject> textList = subjectService.showList(teacher.getId());
		List<Textmodel> textModelList = textModelService.showList();
		model.addAttribute("textList", textList);
		model.addAttribute("textModelList", textModelList);
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("text", text);
		return "/text/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateText(Text text){
		
		Integer chapterid = text.getChapterid();
		Chapter chapter = chapterService.selectOne(chapterid);
		text.setChaptername(chapter.getName()+"   "+chapter.getTitle());
		
		Integer subjectid = text.getSubjectid();
		Subject subject = subjectService.selectOne(subjectid);
		text.setSubjectname(subject.getName());
		
		Integer texId = text.getTexId();
		Textmodel textmodel = textModelService.selectOne(texId);
		text.setModelname(textmodel.getTexttype());
		
		textService.update(text);
		return AjaxResult.successInstance("修改成功");
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody AjaxResult deleteText(int id){
		
		textService.delete(id);
		return AjaxResult.successInstance("删除成功");
	}
	
	@RequestMapping("/showChapter")
	public @ResponseBody List<Chapter> listChapter(Integer id, HttpServletResponse response){
		
		List<Chapter> list = chapterService.getChapter(id);
		
		return list;
	}
	
}
