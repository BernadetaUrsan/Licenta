package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.licenta.Adapters.CommentsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.CommentModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnePostActivity extends BaseActivity {
    private String postId;
    private TextView subjectTv, messageTv, dateTv, timeTv, authorTv;
    private RecyclerView commentsRv;
    private List<CommentModel> commentsList;
    private CommentsAdapter commentsAdapter;
    private EditText commentEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);
        super.setToolbarTitle("Postare");
        initializeViews();
        postId = getIntent().getStringExtra("id_key");

        FirebaseHelper.getInstance().yearGroupPostsDatabase.child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                PostModel post = dataSnapshot.getValue(PostModel.class);
                setData(post);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        FirebaseHelper.getInstance().postCommentsDatabase.child(postId).orderByChild("date/time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentsList = new ArrayList<>();
                for (DataSnapshot data: dataSnapshot.getChildren()
                     ) {
                    commentsList.add(data.getValue(CommentModel.class));
                }
                if (commentsList != null)
                {
                    setCommentsRecycler();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setData(PostModel post)
    {
        subjectTv.setText(post.getTitle());
        messageTv.setText(post.getMessage());
        dateTv.setText(post.getDate().toString().substring(11,16));
        timeTv.setText(post.getDate().toString().substring(4,10));
        authorTv.setText(post.getAuthorName());
    }

    private void setCommentsRecycler()
    {
        commentsRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        commentsAdapter = new CommentsAdapter(commentsList, this);
        commentsRv.setAdapter(commentsAdapter);
    }

    public void OnAddComment(View view) {
        if(commentEt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Adaugă comentariul", Toast.LENGTH_SHORT).show();
        }
        else{
            Date currentTime = Calendar.getInstance().getTime();
            CommentModel newComment = new CommentModel();
            newComment.setFullName(UserHelper.Instance().getFullName());
            newComment.setDate(currentTime);
            newComment.setMessage(commentEt.getText().toString());

            FirebaseHelper.getInstance().postCommentsDatabase.child(postId).push().setValue(newComment);
            commentEt.setText("");
        }
    }

    private void initializeViews()
    {
        subjectTv = findViewById(R.id.tv_post_title);
        messageTv = findViewById(R.id.tv_text_subject);
        authorTv = findViewById(R.id.tv_author);
        dateTv = findViewById(R.id.tv_date_subject);
        timeTv = findViewById(R.id.tv_hour_subject);
        commentsRv = findViewById(R.id.rv_listed_comments);
        commentEt = findViewById(R.id.et_post_new_comment);
    }
}
