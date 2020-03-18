package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.Fragments.ProfileFragment;
import com.example.licenta.R;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void OnSave(View view) {
        //this.finish();
        Intent myInt= new Intent(EditProfileActivity.this, ProfileFragment.class);
        startActivity(myInt);
    }

    public void OnCancel(View view) {

        Intent myInt2= new Intent(EditProfileActivity.this, ProfileFragment.class);
        startActivity(myInt2);
    }

}
