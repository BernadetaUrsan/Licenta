package com.example.licenta.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void OnSignOut(View view) {
        Intent myInt= new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(myInt);
    }

    public void OnEditProfile(View view) {
        Intent myInt= new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivity(myInt);
    }
}
