package com.example.licenta.Activities;

import android.os.Bundle;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YearGroupActivity extends BaseActivity {

    private YearPostsAdapter yearPostsAdapter;
    private List<PostModel> postsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_group);
        super.setToolbarTitle("Year Group");
        initializeViews();

        postsList = new ArrayList<>();


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        yearPostsAdapter = new YearPostsAdapter(postsList,getApplicationContext());
        recyclerView.setAdapter(yearPostsAdapter);
    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_yeargroup);
    }
}
