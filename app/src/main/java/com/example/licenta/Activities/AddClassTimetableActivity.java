package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.licenta.R;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.auth.FirebaseAuth;

public class AddClassTimetableActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText materieEt;
    private EditText salaEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class_timetable);

        initializeViews();
    }

    private void initializeViews()
    {
        materieEt = findViewById(R.id.et_materie);
        salaEt = findViewById(R.id.et_sala);
    }

    public void onAdd(View view) {

    }
}
