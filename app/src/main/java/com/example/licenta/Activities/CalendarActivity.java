package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.licenta.Adapters.CalendarAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.CalendarRowModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CalendarActivity extends BaseActivity implements CalendarView.OnDateChangeListener {

    CalendarView calendarView;
    CalendarAdapter calendarAdapter;
    TextView noEvents;
    private String currentDate;
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

    public void OnAddEvent (View view)
    {
        Intent myInt2= new Intent(CalendarActivity.this,AddEventActivity.class);
        Bundle b = new Bundle();
        b.putString("key", currentDate); //Your id
        myInt2.putExtras(b); //Put your id to your next Intent
        startActivity(myInt2);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        currentDate = String.valueOf(dayOfMonth) + String.valueOf(month+1) + String.valueOf(year);
        getDateEvents(currentDate);
    }
}
