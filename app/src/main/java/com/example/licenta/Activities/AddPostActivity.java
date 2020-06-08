package com.example.licenta.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class AddPostActivity extends BaseActivity {
    private PostModel post;
    private EditText titleEt;
    private EditText messageEt;
    private StudentModel student;
    private boolean shouldUpdate;
    private String postID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        initializeViews();
        post = new PostModel();
        if(getIntent().hasExtra("post")){
            Gson gson = new Gson();
            post = gson.fromJson(getIntent().getStringExtra("post"), PostModel.class);
            shouldUpdate = true;
            titleEt.setText(post.getTitle());
            messageEt.setText(post.getMessage());
            postID= post.getId();
        }
    }

    private void getValues(){
        student =  UserHelper.Instance().getStudent();
        post.setTitle(titleEt.getText().toString());
        post.setMessage(messageEt.getText().toString());
        post.setAuthorName(student.getName()+" "+student.getSurname());
        Date currentTime = Calendar.getInstance().getTime();
        post.setDate(currentTime);
        post.setId(UUID.randomUUID().toString());
        post.setAuthorId(UserHelper.Instance().getStudent().getUserId());
    }

    private void initializeViews(){
        titleEt = findViewById(R.id.et_text_subject);
        messageEt = findViewById(R.id.et_post_message);
    }

    public void onAddPost(View view) {
        if(titleEt.getText().toString().isEmpty() || messageEt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Adaugă informațiile anunțului", Toast.LENGTH_SHORT).show();
        }
        else {
            getValues();
            if(shouldUpdate)
            {
                HashMap<String, Object> map = new HashMap<>();
                post.setId(postID);
                map.put("message", post.getMessage());
                map.put("title", post.getTitle());
                FirebaseHelper.getInstance().yearGroupPostsDatabase.child(post.getId()).updateChildren(map);
                finish();
                return;
            }
            FirebaseHelper.getInstance().yearGroupPostsDatabase.child(post.getId()).setValue(post);
            finish();
        }
    }
}
