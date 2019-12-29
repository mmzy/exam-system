package com.exam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exam.mapper.SubjectMapper;
import com.exam.mapper.TextmodelMapper;
import com.exam.pojo.*;
import com.exam.pojo.util.TextModel;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.mapper.TeacherSubjectMapper;
import com.exam.mapper.TextMapper;
import com.exam.pojo.TextExample.Criteria;
import com.exam.service.TextService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextMapper textMapper;
    @Autowired
    private TeacherSubjectMapper teacherSubjectMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TextmodelMapper textmodelMapper;

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

    @Override
    @Transactional
    public List<Integer> batchInsert(List<Text> Texts) {
        List<Integer> failList = new ArrayList<Integer>();
        int index = 0;
        for (Text txt : Texts) {
            index++;
            int i = textMapper.insert(txt);
            if (i == 0) {
                failList.add(index);
            }
        }
        return failList;
    }


    @Override
    public List<Text> orderExcelDataToText(List<List<Object>> infos) {
        List<Text> allSubjectsJoinChapter = textMapper.selectAllSubjectJoinChapter();
        Map<String,Text> subjectChapterMap = new HashMap<String,Text>();
        for (Text text: allSubjectsJoinChapter) {
            subjectChapterMap.put(text.getSubjectid()+"-"+text.getChapterid(),text);
        }

        List<Textmodel> textModels =  textmodelMapper.selectByExample(new TextmodelExample());
        Map<Integer,String> textModelMap = new HashMap<>();
        for (Textmodel textmodel:textModels){
            textModelMap.put(textmodel.getId(),textmodel.getTexttype());
        }

        List<Text> texts = new ArrayList<Text>();
        for (int i = 0; i < infos.size(); i++) {
            List<Object> row = infos.get(i);
            Text text = new Text();
            if(row.get(0)!= null&&row.get(1)!=null){
                int subjectid = Integer.parseInt(row.get(0).toString());
                int chapterid = Integer.parseInt(row.get(1).toString());
                Text thisText = subjectChapterMap.get(subjectid+"-"+chapterid);
                text.setSubjectid(subjectid);
                text.setSubjectname(thisText.getSubjectname());
                text.setChapterid(chapterid);
                text.setChaptername(thisText.getChaptername());
            }else if(row.get(0)!=null){
                text.setSubjectid(Integer.parseInt(row.get(0).toString()));
                text.setSubjectname("");
            }else if(row.get(1)!=null){
                text.setChapterid(Integer.parseInt(row.get(1).toString()));
                text.setChaptername("");
            }

            if(row.get(2)!=null){
                Integer tex_id = Integer.parseInt(row.get(2).toString());
                text.setTexId(tex_id);//试题模块
                text.setModelname(textModelMap.get(tex_id));
            }
            if(row.get(3)!=null){
                text.setDiffculty(Integer.parseInt(row.get(3).toString()));
            }
            if(row.get(4)!=null){
                text.setTitle(row.get(4).toString());
            }
            if(row.get(5)!=null){
                text.setType1(row.get(5).toString());
            }
            if(row.get(6)!=null){
                text.setType2(row.get(6).toString());
            }
            if(row.get(7)!=null){
                text.setType3(row.get(7).toString());
            }
            if(row.get(8)!=null){
                text.setType4(row.get(8).toString());
            }
            if(row.get(9)!=null){
                text.setAnswer(row.get(9).toString());
            }
            texts.add(text);
        }
        return texts;
    }
}
