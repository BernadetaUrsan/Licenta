package com.example.licenta.Activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;

import java.util.ArrayList;
import java.util.List;

public class ParkingActivity extends BaseActivity {

    private YearPostsAdapter parkingsAdapter;
    private List<PostModel> postsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        super.setToolbarTitle("Parking group");
        initializeViews();

        postsList = new ArrayList<>();


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        parkingsAdapter = new YearPostsAdapter(postsList, getApplicationContext());
        recyclerView.setAdapter(parkingsAdapter);
    }

    private void initializeViews(){

        recyclerView = findViewById(R.id.rv_listed_parkings);
    }
}
