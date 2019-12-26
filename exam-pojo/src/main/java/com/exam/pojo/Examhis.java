package com.exam.pojo;

public class Examhis extends ExamhisKey {
    private String studentname;

    private String subjectname;

    private Integer classesid;

    private String classesname;

    private Integer score;
    
    //开始考试状态为1，考完状态为2，批阅成功状态为3
    private Integer status;

    private Integer publishexamid;

    private String examtest;

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname == null ? null : subjectname.trim();
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public String getClassesname() {
        return classesname;
    }

    public void setClassesname(String classesname) {
        this.classesname = classesname == null ? null : classesname.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPublishexamid() {
        return publishexamid;
    }

    public void setPublishexamid(Integer publishexamid) {
        this.publishexamid = publishexamid;
    }

    public String getExamtest() {
        return examtest;
    }

    public void setExamtest(String examtest) {
        this.examtest = examtest == null ? null : examtest.trim();
    }
}