package com.exam.service;

import java.util.ArrayList;
import java.util.List;

import com.exam.pojo.Textmodel;
import com.exam.pojo.util.TextModel;
import com.github.pagehelper.PageInfo;

public interface TextModelService {
	
	//分页查询试题模块
	PageInfo<Textmodel> showList(int pageNum, int pageSize);
	
	List<Textmodel> showList();
	
	//判断是否有重名的试题模块
	boolean isExisted(Textmodel textModel);
	//插入试题模块
	void insert(Textmodel textmodel);
	//修改试题模块
	void update(Textmodel textmodel);
	//根据主键查询试题模块
	Textmodel selectOne(int id);
	//删除试题模块
	void delete(int id);

	List<Textmodel> selectTextModel(ArrayList<TextModel> list);
	
	
}
