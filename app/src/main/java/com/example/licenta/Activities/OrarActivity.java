package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.licenta.Adapters.TimetableAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class OrarActivity extends AppCompatActivity {

    TextView luni, marti, miercuri, joi, vineri;
    private TimetableAdapter timetableAdapter;
    private List<TimetabelModel> timetableList;
    private RecyclerView recyclerView;
    private TimetabelModel timetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);
        initializeViews();

        FirebaseHelper.getInstance().timetableDatabase.child(UserHelper.Instance().getFirebaseUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
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

    private void SetRecyclerView(List<TimetableRowModel> timetableRow)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        timetableAdapter = new TimetableAdapter(timetableRow, getApplicationContext());
        recyclerView.setAdapter(timetableAdapter);
    }

    public void OnLuni (View view){
        luni.setTextSize(26);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
        SetRecyclerView(timetable.getmWeeklyTimetable().get(0).getmDailyTimetable());
    }

    public void OnMarti (View view){
        luni.setTextSize(16);
        marti.setTextSize(26);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
        SetRecyclerView(timetable.getmWeeklyTimetable().get(1).getmDailyTimetable());
    }

    public void OnMiercuri (View view)
    {
        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(26);
        joi.setTextSize(16);
        vineri.setTextSize(16);
        SetRecyclerView(timetable.getmWeeklyTimetable().get(2).getmDailyTimetable());
    }

    public void OnJoi (View view)
    {
        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(26);
        vineri.setTextSize(16);
        SetRecyclerView(timetable.getmWeeklyTimetable().get(3).getmDailyTimetable());
    }

    public void OnVineri (View view)
    {
        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(26);
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
}