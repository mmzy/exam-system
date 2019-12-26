package com.exam.service;

import java.util.List;

import com.exam.pojo.Chapter;
import com.github.pagehelper.PageInfo;

public interface ChapterService {
	
	//分页查询章节
	PageInfo<Chapter> showList(int pageNum, int pageSize, int subjectId);
	//判断是否有重名的章节
	boolean isExisted(Chapter chapter);
	//插入章节
	void insert(Chapter chapter);
	//修改章节
	void update(Chapter chapter);
	//根据主键查询章节
	Chapter selectOne(int id);
	//删除章节
	void delete(int id);
	//根据科目id查询章节
	List<Chapter> getChapter(Integer subId);
	//根据科目id查询是否有章节
	boolean isEmpty(int classesId);
}
