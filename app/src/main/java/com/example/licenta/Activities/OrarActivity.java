package com.example.licenta.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Adapters.TimetableAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Interfaces.TimetableClickListener;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class OrarActivity extends BaseActivity implements TimetableClickListener {
    private static final int LAUNCH_ACTIVITY = 7419;
    TextView luni, marti, miercuri, joi, vineri;
    private TimetableAdapter timetableAdapter;
    private RecyclerView recyclerView;
    private TimetabelModel timetable;
    private int changedRowPosition = -1;
    private int selectedDayPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);
        initializeViews();
        setToolbarTitle("Orar");

        FirebaseHelper.getInstance().timetableDatabase.child(UserHelper.Instance().getStudent().getUserId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                timetable = dataSnapshot.getValue(TimetabelModel.class);
                luni.setTextSize(26);
                SetRecyclerView(timetable.getmWeeklyTimetable().get(0).getmDailyTimetable());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void SetRecyclerView(List<TimetableRowModel> timetableRows)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        timetableAdapter = new TimetableAdapter(timetableRows, getApplicationContext(), this);
        recyclerView.setAdapter(timetableAdapter);
    }

    public void OnLuni (View view){
        luni.setTextSize(26);
        marti.setTextSize(12);
        miercuri.setTextSize(12);
        joi.setTextSize(12);
        vineri.setTextSize(12);
        selectedDayPosition = 0;
        SetRecyclerView(timetable.getmWeeklyTimetable().get(0).getmDailyTimetable());
    }

    public void OnMarti (View view){
        luni.setTextSize(12);
        marti.setTextSize(26);
        miercuri.setTextSize(12);
        joi.setTextSize(12);
        vineri.setTextSize(12);
        selectedDayPosition = 1;
        SetRecyclerView(timetable.getmWeeklyTimetable().get(1).getmDailyTimetable());
    }

    public void OnMiercuri (View view)
    {
        luni.setTextSize(12);
        marti.setTextSize(12);
        miercuri.setTextSize(26);
        joi.setTextSize(12);
        vineri.setTextSize(12);
        selectedDayPosition = 2;
        SetRecyclerView(timetable.getmWeeklyTimetable().get(2).getmDailyTimetable());
    }

    public void OnJoi (View view)
    {
        luni.setTextSize(12);
        marti.setTextSize(12);
        miercuri.setTextSize(12);
        joi.setTextSize(26);
        vineri.setTextSize(12);
        selectedDayPosition = 3;
        SetRecyclerView(timetable.getmWeeklyTimetable().get(3).getmDailyTimetable());
    }

    public void OnVineri (View view)
    {
        luni.setTextSize(12);
        marti.setTextSize(12);
        miercuri.setTextSize(12);
        joi.setTextSize(12);
        vineri.setTextSize(26);
        selectedDayPosition = 4;
        SetRecyclerView(timetable.getmWeeklyTimetable().get(4).getmDailyTimetable());
    }

    private void initializeViews(){
        luni = findViewById(R.id.tv_luni);
        marti = findViewById(R.id.tv_marti);
        miercuri = findViewById(R.id.tv_miercuri);
        joi = findViewById(R.id.tv_joi);
        vineri = findViewById(R.id.tv_vineri);
        recyclerView= findViewById(R.id.rv_timetable);
    }

    @Override
    public void OnClick(TimetableRowModel timetableRowModel, int position) {
        Intent intent = new Intent(this, AddClassTimetableActivity.class);
        intent.putExtra("class_id", timetableRowModel);
        startActivityForResult(intent, LAUNCH_ACTIVITY);
        changedRowPosition = position;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                Object obj =  data.getSerializableExtra("class_id");
                TimetableRowModel rowModel = (TimetableRowModel)obj;
                timetable.getmWeeklyTimetable().get(selectedDayPosition).getmDailyTimetable().get(changedRowPosition).setTimetableRowModel(rowModel);
                timetableAdapter.notifyDataSetChanged();
            }
        }
    }

    public void OnSaveTimetable(View view){
        FirebaseHelper.getInstance().timetableDatabase.child(UserHelper.Instance().getStudent().getUserId()).setValue(timetable);
    }
}