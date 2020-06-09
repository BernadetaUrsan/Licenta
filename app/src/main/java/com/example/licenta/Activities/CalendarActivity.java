package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.licenta.Adapters.CalendarAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.CalendarRowModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends BaseActivity implements CalendarView.OnDateChangeListener {

    CalendarView calendarView;
    CalendarAdapter calendarAdapter;
    TextView noEvents;
    private String currentDate;
    private String todayDate;
    RecyclerView eventsRecyclerView;
    private ArrayList<CalendarRowModel> eventsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        setToolbarTitle("Calendar");

        calendarView = findViewById(R.id.cv_calendar_view);
        noEvents = findViewById(R.id.tv_no_events);
        eventsRecyclerView = findViewById(R.id.rv_events_list);
        calendarView.setOnDateChangeListener(this);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        todayDate= formatter.format(date);
    }


    private void getDateEvents(String date){
        eventsList.clear();
        FirebaseHelper.getInstance().calendarDatabase.child(date).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    CalendarRowModel post = data.getValue(CalendarRowModel.class);
                    eventsList.add(post);
                }
                setAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void setAdapter(){
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        calendarAdapter = new CalendarAdapter(eventsList, this);
        eventsRecyclerView.setAdapter(calendarAdapter);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        String monthString = new String();
        String dayString = new String();
        if (month < 10 && dayOfMonth <10) {
        currentDate = String.valueOf(year) + "0" + String.valueOf(month+1) + "0" +String.valueOf(dayOfMonth);
        }
        else {
            if(dayOfMonth<10){
                currentDate = String.valueOf(year)  + String.valueOf(month+1) + "0" + String.valueOf(dayOfMonth);
            }
            else{
                if(month<10){
                    currentDate = String.valueOf(year) + "0" + String.valueOf(month + 1) + String.valueOf(dayOfMonth);
                }
                else {
                    currentDate = String.valueOf(year) + String.valueOf(month + 1) + String.valueOf(dayOfMonth);
                }
            }
        }
        getDateEvents(currentDate);
    }

    public void OnAddEvent (View view)
    {
        if(todayDate.compareTo(currentDate) > 0){
            Toast.makeText(getApplicationContext(),"Nu se pot adăuga evenimete în trecut",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent myInt2= new Intent(CalendarActivity.this,AddEventActivity.class);
            Bundle b = new Bundle();
            b.putString("key", currentDate); //Your id
            myInt2.putExtras(b); //Put your id to your next Intent
            startActivity(myInt2);
        }

    }
}
