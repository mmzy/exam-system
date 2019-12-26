package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.TeacherSubjectMapper;
import com.exam.mapper.TextMapper;
import com.exam.pojo.TeacherSubjectExample;
import com.exam.pojo.TeacherSubjectKey;
import com.exam.pojo.Text;
import com.exam.pojo.TextExample;
import com.exam.pojo.TextExample.Criteria;
import com.exam.pojo.util.TextModel;
import com.exam.service.TextService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TextServiceImpl implements TextService{
	
	@Autowired
	private TextMapper textMapper;
	@Autowired
	private TeacherSubjectMapper teacherSubjectMapper;
	
	@Override
	public PageInfo<Text> showList(int pageNum, int pageSize, String id) {
		
		
		TeacherSubjectExample example1 = new TeacherSubjectExample();
		com.exam.pojo.TeacherSubjectExample.Criteria criteria2 = example1.createCriteria();
		criteria2.andIdEqualTo(id);
		List<TeacherSubjectKey> list2 = teacherSubjectMapper.selectByExample(example1);
		List<Integer> subjectIdList = new ArrayList<Integer>();
		for (TeacherSubjectKey key : list2) {
			subjectIdList.add(key.getSubId());
		}
		
		PageHelper.startPage(pageNum, pageSize);
		TextExample example = new TextExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubjectidIn(subjectIdList);
		
		List<Text> list = textMapper.selectByExample(example);
		return new PageInfo<Text>(list);
	}

	/*@Override
	public boolean isExisted(Text text) {

		TextExample example = new TextExample();
		Criteria criteria = example.createCriteria();
		//查找该学科名是否已经在数据库中
		criteria.andTexttypeEqualTo(text.getTexttype());
		List<Text> list = textMapper.selectByExample(example);
		if (CommonUtils.isEmpty(list)){
			return false;
		}
		return true;
	}
*/
	@Override
	public void insert(Text text) {
		textMapper.insert(text);
	}

	@Override
	public void update(Text text) {
		textMapper.updateByPrimaryKey(text);
	}

	@Override
	public Text selectOne(int id) {
		
		Text text = textMapper.selectByPrimaryKey(id);
		return text;
	}

	@Override
	public void delete(int id) {
		textMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Text> beginExam(TextModel textModel, Integer subjectId) {
		
		List<Text> list = textMapper.selectRandomText(textModel.getTextModelId(), subjectId, textModel.getTextCount());
		return list;
		
	}
}
