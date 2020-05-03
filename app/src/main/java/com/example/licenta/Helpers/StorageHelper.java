package com.example.licenta.Helpers;

import com.example.licenta.Enums.ClassTypeEnum;
import com.example.licenta.Models.DailyTimetable;
import com.example.licenta.Models.LocationModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.Models.TimetableRowModel;

import java.util.ArrayList;

import static com.example.licenta.Enums.ClassTypeEnum.NOT_SET;

public class StorageHelper {
    public static ArrayList<LocationModel> myLocationsList;

    public static ArrayList<LocationModel> mockLocations()
    {
        if (myLocationsList == null)
        {
            myLocationsList = new ArrayList<>();
        }
        myLocationsList.add(new LocationModel("Biblioteca UPT",45.7471136, 21.2288018));
        myLocationsList.add(new LocationModel("Cantina UPT Complex",45.7486162, 21.2397998));
        myLocationsList.add(new LocationModel("Baza Sportivă Nr.1",45.7464279,21.2295189));
        myLocationsList.add(new LocationModel("Baza Sportivă Nr.2", 45.7432417, 21.2479054));
        myLocationsList.add(new LocationModel("Policlinica Studențească",45.7495498,21.2396244));
        myLocationsList.add(new LocationModel("Rectorat UPT",45.7533855 ,21.2249642));
        return  myLocationsList;
    }

    public static void InitEmptyTimetable(String userId)
    {
        TimetabelModel timetabelModel = new TimetabelModel();
        timetabelModel.setmWeeklyTimetable(new ArrayList<DailyTimetable>());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());
        timetabelModel.getmWeeklyTimetable().add(new DailyTimetable());

        timetabelModel.getmWeeklyTimetable().get(0).setmDailyTimetable(new ArrayList<TimetableRowModel>());
        timetabelModel.getmWeeklyTimetable().get(1).setmDailyTimetable(new ArrayList<TimetableRowModel>());
        timetabelModel.getmWeeklyTimetable().get(2).setmDailyTimetable(new ArrayList<TimetableRowModel>());
        timetabelModel.getmWeeklyTimetable().get(3).setmDailyTimetable(new ArrayList<TimetableRowModel>());
        timetabelModel.getmWeeklyTimetable().get(4).setmDailyTimetable(new ArrayList<TimetableRowModel>());

        for (int i =0; i< 5; i++)
        {
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "08:00", "10:00", NOT_SET));
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "10:00", "12:00", NOT_SET));
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "12:00", "14:00", NOT_SET));
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "14:00", "16:00", NOT_SET));
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "16:00", "18:00", NOT_SET));
            timetabelModel.getmWeeklyTimetable().get(i).getmDailyTimetable().add(new TimetableRowModel("", "", "18:00", "20:00", NOT_SET));
        }

        FirebaseHelper.getInstance().timetableDatabase.child(userId).setValue(timetabelModel);
    }
}
