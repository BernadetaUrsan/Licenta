package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.licenta.Activities.CalendarActivity;
import com.example.licenta.Activities.MapActivity;
import com.example.licenta.Activities.NewsActivity;
import com.example.licenta.Activities.OrarActivity;
import com.example.licenta.Activities.SchedulesActivity;
import com.example.licenta.Activities.YearGroupActivity;
import com.example.licenta.R;

public class HomeFragment extends Fragment {

    private CardView yearGroupV;
    private CardView newsV;
    private CardView schedulesV;
    private CardView calendarV;
    private CardView orarV;
    private CardView hartaV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initializeViews(rootView);

        yearGroupV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt2 = new Intent(getActivity(), YearGroupActivity.class);
                startActivity(myInt2);
            }
        });

        newsV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt4 = new Intent(getActivity(), NewsActivity.class);
                startActivity(myInt4);
            }
        });

        schedulesV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt5 = new Intent(getActivity(), SchedulesActivity.class);
                startActivity(myInt5);
            }
        });

        calendarV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt6 = new Intent(getActivity(), CalendarActivity.class);
                startActivity(myInt6);
            }
        });

        orarV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt7 = new Intent(getActivity(), OrarActivity.class);
                startActivity(myInt7);
            }
        });

        hartaV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt8 = new Intent(getActivity(), MapActivity.class);
                startActivity(myInt8);
            }
        });

        return rootView;
    }

    private void initializeViews(View view){
        yearGroupV = view.findViewById(R.id.cv_year);
        newsV = view.findViewById(R.id.cv_news);
        schedulesV = view.findViewById(R.id.cv_schedule);
        calendarV = view.findViewById(R.id.cv_calendar);
        orarV = view.findViewById(R.id.cv_orar);
        hartaV = view.findViewById(R.id.cv_harta);
    }
}