package com.zyt.android50.model;

import io.realm.RealmObject;

/**
 * Created by user on 2017/2/15.
 */

public class Chapter extends RealmObject {

    private String chapterId;
    private String classId;
    private String classDetail;


    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassDetail() {
        return classDetail;
    }

    public void setClassDetail(String classDetail) {
        this.classDetail = classDetail;
    }
}
