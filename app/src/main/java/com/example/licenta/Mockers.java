package com.example.licenta;

import com.example.licenta.Enums.ClassTypeEnum;
import com.example.licenta.Models.DailyTimetable;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.Models.TimetableRowModel;

import java.util.ArrayList;

public class Mockers {
    public static TimetabelModel getMockTimetable()
    {
        TimetableRowModel rowModel = new TimetableRowModel("Maths", "A106", "12:00", "14:00", ClassTypeEnum.COURSE);
        TimetabelModel timetabelModel = new TimetabelModel();
        timetabelModel.setmWeeklyTimetable(new ArrayList<DailyTimetable>());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());

        DailyTimetable aux =  timetabelModel.getmWeeklyTimetable().get(0);

        return  timetabelModel;
    }
}