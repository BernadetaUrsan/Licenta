package com.example.licenta.Models;

import java.util.List;

public class TimetabelModel {
    private List<DailyTimetable> mWeeklyTimetable;

    public List<DailyTimetable> getmWeeklyTimetable() {
        return mWeeklyTimetable;
    }

    public void setmWeeklyTimetable(List<DailyTimetable> mWeeklyTimetable) {
        this.mWeeklyTimetable = mWeeklyTimetable;
    }
}
