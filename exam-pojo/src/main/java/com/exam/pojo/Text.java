package com.exam.pojo;

public class Text {
    private Integer id;

    private Integer texId;

    private String title;

    private String answer;
    
    //1简单    2一般   3困难
    private Integer diffculty;

    private String modelname;

    private String subjectname;

    private Integer subjectid;

    private Integer chapterid;

    private String chaptername;

    private String type1;

    private String type2;

    private String type3;

    private String type4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTexId() {
        return texId;
    }

    public void setTexId(Integer texId) {
        this.texId = texId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getDiffculty() {
        return diffculty;
    }

    public void setDiffculty(Integer diffculty) {
        this.diffculty = diffculty;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname == null ? null : subjectname.trim();
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername == null ? null : chaptername.trim();
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1 == null ? null : type1.trim();
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2 == null ? null : type2.trim();
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3 == null ? null : type3.trim();
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4 == null ? null : type4.trim();
    }
}