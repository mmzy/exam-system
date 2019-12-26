package com.exam.pojo;

public class Textmodel {
    private Integer id;

    private String texttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexttype() {
        return texttype;
    }

    public void setTexttype(String texttype) {
        this.texttype = texttype == null ? null : texttype.trim();
    }
}