package com.developer.skylight.multipleviewtyperecyclerview.model;

/**
 * Created by akash.wangalwar on 24/07/18.
 */

public class Records {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(int isStudent) {
        this.isStudent = isStudent;
    }

    public int getIsFirstRecord() {
        return isFirstRecord;
    }

    public void setIsFirstRecord(int isFirstRecord) {
        this.isFirstRecord = isFirstRecord;
    }

    private String name;
    private int isStudent;
    private int isFirstRecord;
}
