package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.CommentModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AddPostActivity extends BaseActivity {
    private PostModel post;
    private EditText titleEt;
    private EditText messageEt;
    private ShareDialog shareDialog;
    private StudentModel student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        initializeViews();
        post = new PostModel();
        shareDialog = new ShareDialog(this);  // initialize facebook shareDialog.
    }

    private void getValues(){
        student =  UserHelper.Instance().getStudent();
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
        FirebaseHelper.yearGroupPostsDatabase.child(post.getId()).setValue(post);
        finish();
    }

    public void shareOnFacebook(View view) {
        getValues();
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle(titleEt.getText().toString())
                    .setQuote(messageEt.getText().toString())
                    .setImageUrl(Uri.parse("https://www.studytutorial.in/wp-content/uploads/2017/02/FacebookLoginButton-min-300x136.png"))
                    .setContentUrl(Uri.parse("https://www.studytutorial.in/android-facebook-integration-and-login-tutorial"))
                    .build();
            shareDialog.show(linkContent);
        }
    }
}
