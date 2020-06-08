package com.example.licenta.Activities;

import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YearGroupActivity extends BaseActivity {

    private YearPostsAdapter yearPostsAdapter;
    private List<PostModel> postsList;
    private RecyclerView recyclerView;
    private PostModel deletedPost;
    private PostModel editedPost;
    private StudentModel student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_group);
        super.setToolbarTitle("Postări studenți");
        initializeViews();
        getData();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition();
            editedPost = postsList.get(position);
            student =  UserHelper.Instance().getStudent();
            String userId = student.getUserId();
            if(!editedPost.getAuthorId().equals(userId)){
                return;
            }
            switch(direction){
                case ItemTouchHelper.LEFT:
                    deletedPost = postsList.get(position);
                    postsList.remove(position);
                    yearPostsAdapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    editedPost = postsList.get(position);
                    Gson gson = new Gson();
                    String postString = gson.toJson(editedPost);
                    Intent intent = new Intent(YearGroupActivity.this,AddPostActivity.class);
                    intent.putExtra("post", postString);
                    startActivity(intent);
                    break;
            }
        }
    };

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
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setReverseLayout(true);
                linearLayoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(linearLayoutManager);
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
