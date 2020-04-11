package com.example.licenta.Models;

import com.example.licenta.Enums.ClassTypeEnum;

public class TimetableRowModel {
    private String mClassName;
    private String mLocationName;
    private String mStartTime;
    private String mEndTime;
    private ClassTypeEnum mClassType;

    public TimetableRowModel() {
    }

    public TimetableRowModel(String mClassName, String mLocationName, String mStartTime, String mEndTime, ClassTypeEnum mClassType) {
        this.mClassName = mClassName;
        this.mLocationName = mLocationName;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mClassType = mClassType;
    }

    public String getmClassName() {
        return mClassName;
    }

    public void setmClassName(String mClassName) {
        this.mClassName = mClassName;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public void setmLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public String getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(String mStartTime) {
        this.mStartTime = mStartTime;
    }

    public String getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(String mEndTime) {
        this.mEndTime = mEndTime;
    }

    public ClassTypeEnum getmClassType() {
        return mClassType;
    }

    public void setmClassType(ClassTypeEnum mClassType) {
        this.mClassType = mClassType;
    }
}
