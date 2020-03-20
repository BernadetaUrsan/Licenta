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
        myLocationsList.add(new LocationModel("Biblioteca UPT",45.7472551, 21.2269008));
        myLocationsList.add(new LocationModel("Cantina UPT Complex",45.746764, 21.2287966));
        myLocationsList.add(new LocationModel("Baza Sportivă Nr.1",45.7461175,21.2262214));
        myLocationsList.add(new LocationModel("Baza Sportivă Nr.2", 45.7432298, 21.2470745));
        myLocationsList.add(new LocationModel("Policlinica Studențească",45.7495547,21.2398626));
        myLocationsList.add(new LocationModel("Rectorat UPT",45.7536393 ,21.2229675));
        return  myLocationsList;
    }
}
