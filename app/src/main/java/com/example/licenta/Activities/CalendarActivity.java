package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.licenta.R;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    EditText myEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.cv_calendar_view);
        myDate = (TextView) findViewById(R.id.tv_calendar);
        myEvent = (EditText) findViewById(R.id.et_event);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month+1) + "/" + dayOfMonth + "/" + year;
                myDate.setText(date);
                myEvent.setText("Niciun eveniment salvat");
                myEvent.setVisibility(View.VISIBLE);
            }
        });
    }

    public void OnAddEvent (View view)
    {
        myEvent.setText(" ");
    }
}
