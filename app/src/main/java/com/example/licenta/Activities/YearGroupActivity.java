package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.widget.Adapter;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.YearPosts;
import com.example.licenta.R;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class YearGroupActivity extends AppCompatActivity {

    private YearPostsAdapter yearPostsAdapter;
    private List<YearPosts> postsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_group);
        initializeViews();

        postsList = new ArrayList<>();
        postsList.add(new YearPosts("Contracte","se gasesc in sediu","26.10.2019","21:14"));
        postsList.add(new YearPosts("Carnete","blab alafelghl","14.10.2019","23:01"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        yearPostsAdapter = new YearPostsAdapter(postsList,getApplicationContext());
        recyclerView.setAdapter(yearPostsAdapter);
    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_yeargroup);
    }
}
