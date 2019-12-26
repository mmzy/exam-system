package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.TextmodelMapper;
import com.exam.pojo.Textmodel;
import com.exam.pojo.TextmodelExample;
import com.exam.pojo.TextmodelExample.Criteria;
import com.exam.pojo.util.TextModel;
import com.exam.service.TextModelService;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TextModelServiceImpl implements TextModelService{
	
	@Autowired
	private TextmodelMapper textmodelMapper;
	
	@Override
	public PageInfo<Textmodel> showList(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		TextmodelExample example = new TextmodelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		
		List<Textmodel> list = textmodelMapper.selectByExample(example);
		
		return new PageInfo<Textmodel>(list);
	}

	@Override
	public boolean isExisted(Textmodel textModel) {

		TextmodelExample example = new TextmodelExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andTexttypeEqualTo(textModel.getTexttype());
		List<Textmodel> list = textmodelMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}

	@Override
	public void insert(Textmodel textmodel) {
		textmodelMapper.insert(textmodel);
	}

	@Override
	public void update(Textmodel textmodel) {
		textmodelMapper.updateByPrimaryKey(textmodel);
	}

	@Override
	public Textmodel selectOne(int id) {
		
		Textmodel textmodel = textmodelMapper.selectByPrimaryKey(id);
		return textmodel;
	}

	@Override
	public void delete(int id) {
		textmodelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Textmodel> showList() {
		TextmodelExample example = new TextmodelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		
		List<Textmodel> list = textmodelMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public List<Textmodel> selectTextModel(ArrayList<TextModel> list) {
		List<Integer> id = new ArrayList<Integer>();
		for (TextModel textModel : list) {
			id.add(textModel.getTextModelId());
		}
		TextmodelExample example = new TextmodelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(id);
		List<Textmodel> list2 = textmodelMapper.selectByExample(example);
		
		return list2;
	}

}
