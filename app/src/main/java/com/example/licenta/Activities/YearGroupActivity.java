package com.example.licenta.Activities;

import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
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
        super.setToolbarTitle("Postări studenți");
        initializeViews();

        getData();
    }

    public void OnAddPost(View view) {
        Intent myInt2= new Intent(YearGroupActivity.this,AddPostActivity.class);
        startActivity(myInt2);
    }

    private void getData(){
        FirebaseHelper.getInstance().yearGroupPostsDatabase.orderByChild("date/time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postsList = new ArrayList<>();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    PostModel post = data.getValue(PostModel.class);
                    postsList.add(post);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                yearPostsAdapter = new YearPostsAdapter(postsList, getApplicationContext());
                recyclerView.setAdapter(yearPostsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_yeargroup);
    }
}
