package com.exam.pojo;

public class PublishexamWithBLOBs extends Publishexam {
    private String description;

    private String exam;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam == null ? null : exam.trim();
    }
}