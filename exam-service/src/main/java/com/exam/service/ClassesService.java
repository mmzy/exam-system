package com.exam.service;

import com.exam.pojo.Classes;
import com.github.pagehelper.PageInfo;

public interface ClassesService {
	
	//分页查询科目
	PageInfo<Classes> showList(int pageNum, int pageSize);
	//插入科目
	void insert(Classes classes);
	//修改科目
	void update(Classes classes);
	//根据主键查询科目
	Classes selectOne(int id);
	//删除科目
	void delete(int id);
}
