package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.ChapterMapper;
import com.exam.pojo.Chapter;
import com.exam.pojo.ChapterExample;
import com.exam.pojo.ChapterExample.Criteria;
import com.exam.service.ChapterService;
import com.exam.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 科目管理Service 
 * @author 王冲
 *
 */
@Service
public class ChapterServiceImpl implements ChapterService{

	@Autowired
	private ChapterMapper chapterMapper;

	@Override
	public PageInfo<Chapter> showList(int pageNum, int pageSize,  int subjectId) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		ChapterExample example = new ChapterExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubIdEqualTo(subjectId);
		
		List<Chapter> list = chapterMapper.selectByExample(example);
		
		return new PageInfo<Chapter>(list);
	}

	@Override
	public boolean isExisted(Chapter chapter) {
		
		ChapterExample example = new ChapterExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andNameEqualTo(chapter.getName());
		List<Chapter> list = chapterMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}

	@Override
	public void insert(Chapter Chapter) {

		chapterMapper.insert(Chapter);
		
	}

	@Override
	public void update(Chapter chapter) {
		
		chapterMapper.updateByPrimaryKey(chapter);
	}

	@Override
	public Chapter selectOne(int id) {

		Chapter chapter = chapterMapper.selectByPrimaryKey(id);
		return chapter;
	}

	@Override
	public void delete(int id) {
		chapterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Chapter> getChapter(Integer subId) {
		
		ChapterExample example = new ChapterExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubIdEqualTo(subId);
		
		List<Chapter> list = chapterMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean isEmpty(int subId) {
		
		ChapterExample example = new ChapterExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubIdEqualTo(subId);
		
		List<Chapter> list = chapterMapper.selectByExample(example);
		if (list == null || list.size() < 1){
			return true;
		}
		return false;
	}
	
}
