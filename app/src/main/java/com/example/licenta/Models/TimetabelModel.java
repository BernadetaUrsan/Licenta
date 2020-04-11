package com.example.licenta.Models;

import java.util.ArrayList;

public class TimetabelModel {
    private ArrayList<DailyTimetable> mWeeklyTimetable;

    public ArrayList<DailyTimetable> getmWeeklyTimetable() {
        return mWeeklyTimetable;
    }

    public void setmWeeklyTimetable(ArrayList<DailyTimetable> mWeeklyTimetable) {
        this.mWeeklyTimetable = mWeeklyTimetable;
    }
}
