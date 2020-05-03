package com.example.licenta.Helpers;

import com.example.licenta.Models.LocationModel;
import com.example.licenta.Models.StudentModel;

import java.util.ArrayList;

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
}
