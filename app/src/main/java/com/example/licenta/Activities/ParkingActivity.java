package com.example.licenta.Activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.licenta.Adapters.ParkingsAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.ParkingsPosts;
import com.example.licenta.Models.YearPosts;
import com.example.licenta.R;

import java.util.ArrayList;
import java.util.List;

public class ParkingActivity extends BaseActivity {

    private YearPostsAdapter parkingsAdapter;
    private List<YearPosts> postsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        super.setToolbarTitle("Parking group");
        initializeViews();

        postsList = new ArrayList<>();
        postsList.add(new YearPosts("Politie","la aspc","26.10.2019","21:14"));
        postsList.add(new YearPosts("Blocat masina","TM 13 BAU","13.10.2019","23:01"));
        postsList.add(new YearPosts("Blocat masina","TM 12 BAU","12.10.2019","23:01"));
        postsList.add(new YearPosts("Blocat masina","TM 11 BAU","11.10.2019","23:01"));
        postsList.add(new YearPosts("Blocat masina","TM 15 BAU","4.10.2019","23:01"));
        postsList.add(new YearPosts("Blocat masina","TM 16 BAU","4.10.2019","23:01"));
        postsList.add(new YearPosts("Politie","la constructii","26.10.2019","21:14"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        parkingsAdapter = new YearPostsAdapter(postsList, getApplicationContext());
        recyclerView.setAdapter(parkingsAdapter);
    }

    private void initializeViews(){

        recyclerView = findViewById(R.id.rv_listed_parkings);
    }
}
