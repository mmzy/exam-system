package com.exam.pojo.util;

import com.exam.pojo.Text;

public class ExamhisAnswer {
	//试题编码
	private Integer textId;
	//试题答案
	private String answer;
	//试题
	private Text text;
	//试题得分
	private Integer grade;
	public Integer getTextId() {
		return textId;
	}
	public void setTextId(Integer textId) {
		this.textId = textId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}
