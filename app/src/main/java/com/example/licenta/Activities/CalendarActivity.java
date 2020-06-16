package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
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
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.github.sundeepk.compactcalendarview.CompactCalendarView.FILL_LARGE_INDICATOR;

public class CalendarActivity extends BaseActivity{

    CompactCalendarView compactCalendarView;
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

        noEvents = findViewById(R.id.tv_no_events);
        eventsRecyclerView = findViewById(R.id.rv_events_list);
        compactCalendarView = findViewById(R.id.cv_calendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);
        compactCalendarView.shouldDrawIndicatorsBelowSelectedDays(true);

        final SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        todayDate= formatter.format(date);
        getDateEvents(todayDate);
        getAllEvents();

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                currentDate = formatter.format(dateClicked.getTime());
                getDateEvents(currentDate);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
            }
        });
    }

    private void getAllEvents()
    {
        FirebaseHelper.getInstance().calendarDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Date newDate = null;
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    CalendarRowModel post = data.getValue(CalendarRowModel.class);
                    try {
                        newDate = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(post.getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Event dayEvent = new Event(Color.MAGENTA, newDate.getTime(), "ceva");
                    compactCalendarView.addEvent(dayEvent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getDateEvents(final String date){
        eventsList.clear();
        FirebaseHelper.getInstance().calendarDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    CalendarRowModel post = data.getValue(CalendarRowModel.class);
                    if (post.getDate().equals(date))
                    {
                        eventsList.add(post);
                    }
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
