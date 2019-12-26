package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.ClassesMapper;
import com.exam.pojo.Classes;
import com.exam.pojo.ClassesExample;
import com.exam.pojo.ClassesExample.Criteria;
import com.exam.service.ClassesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 科目管理Service 
 * @author 王冲
 *
 */
@Service
public class ClassesServiceImpl implements ClassesService{

	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public PageInfo<Classes> showList(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		ClassesExample example = new ClassesExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassesidIsNotNull();
		List<Classes> list = classesMapper.selectByExample(example);
		
		return new PageInfo<Classes>(list);
	}

	

	@Override
	public void insert(Classes classes) {

		classesMapper.insert(classes);
		
	}

	@Override
	public void update(Classes classes) {
		
		classesMapper.updateByPrimaryKey(classes);
	}

	@Override
	public Classes selectOne(int id) {

		Classes classes = classesMapper.selectByPrimaryKey(id);
		return classes;
	}

	@Override
	public void delete(int id) {
		classesMapper.deleteByPrimaryKey(id);
	}
	
}
