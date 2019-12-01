package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class AddPostActivity extends BaseActivity {

    private PostModel post;
    private EditText titleEt;
    private EditText messageEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        initializeViews();
        post = new PostModel();
    }

    private void getValues(){
        StudentModel student =  UserHelper.Instance().getStudent();
        post.setTitle(titleEt.getText().toString());
        post.setMessage(messageEt.getText().toString());
        post.setAuthorName(student.getName()+" "+student.getSurname());
        Date currentTime = Calendar.getInstance().getTime();
        post.setDate(currentTime);
        post.setId(UUID.randomUUID().toString());
    }

    private void initializeViews(){

        titleEt = findViewById(R.id.et_text_subject);
        messageEt = findViewById(R.id.et_post_message);
    }

    public void onAddPost(View view) {
        getValues();
        FirebaseHelper.yearGroupPostsDatabase.child(post.getId().toString()).setValue(post);
        finish();
    }
}
