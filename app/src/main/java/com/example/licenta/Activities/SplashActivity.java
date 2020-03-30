package com.example.licenta.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        try {
            mUser = mAuth.getCurrentUser();
            if (mUser != null) {
                ifLoggedIn(mUser);
            } else {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
        }
    }

    private void ifLoggedIn(final FirebaseUser user) {

        mDatabaseReference = FirebaseHelper.getInstance().usersDatabase.child(user.getUid());
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StudentModel myUser = dataSnapshot.getValue(StudentModel.class);
                UserHelper.Instance().setStudent(myUser);
                UserHelper.Instance().setFirebaseUser(user);
                UserHelper.Instance().setLoggedIn(true);
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}