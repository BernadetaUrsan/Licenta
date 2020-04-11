package com.example.licenta.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;
import com.google.firebase.auth.FirebaseAuth;

public class AddClassTimetableActivity extends BaseActivity {

    private FirebaseAuth mAuth;
    private EditText materieEt;
    private EditText salaEt;
    private TimetableRowModel rowModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class_timetable);
        initializeViews();

        Intent intent = getIntent();
        Object obj =  intent.getSerializableExtra("class_id");
        rowModel = (TimetableRowModel)obj;
        materieEt.setText(rowModel.getmClassName());
        salaEt.setText(rowModel.getmLocationName());
    }

    public void onAdd(View view) {
        rowModel.setmClassName(materieEt.getText().toString());
        rowModel.setmLocationName(salaEt.getText().toString());
        Intent returnIntent = new Intent();
        returnIntent.putExtra("class_id", rowModel);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    private void initializeViews()
    {
        materieEt = findViewById(R.id.et_materie);
        salaEt = findViewById(R.id.et_sala);
    }
}
