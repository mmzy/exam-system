package com.exam.service;

import java.util.List;

import com.exam.pojo.Text;
import com.exam.pojo.util.TextModel;
import com.github.pagehelper.PageInfo;

public interface TextService {
	
	//分页查询试题
	PageInfo<Text> showList(int pageNum, int pageSize, String id);
	/*//判断是否有重名的试题
	boolean isExisted(Text text);*/
	//插入试题
	void insert(Text text);
	//修改试题
	void update(Text text);
	//根据主键查询试题
	Text selectOne(int id);
	//删除试题
	void delete(int id);

	List<Text> beginExam(TextModel textModel, Integer subjectId);

	List<Integer> batchInsert(List<Text> Texts);

	List<Text> orderExcelDataToText(List<List<Object>> infos);
}
