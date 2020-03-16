package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.licenta.Activities.FindStudentActivity;
import com.example.licenta.Activities.SendMailActivity;
import com.example.licenta.Activities.YearGroupActivity;
import com.example.licenta.R;

public class NotificationsFragment extends Fragment {

    private CardView mesajProf;
    private CardView mesajStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_notifications, container, false);
        initializeViews(rootView);

        mesajProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt2 = new Intent(getContext(), SendMailActivity.class);
                startActivity(myInt2);
            }
        });

        mesajStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt3 = new Intent(getContext(), FindStudentActivity.class);
                startActivity(myInt3);
            }
        });

        return rootView;
    }

    private void initializeViews(View view){
        mesajProf = view.findViewById(R.id.cv_2);
        mesajStudent = view.findViewById(R.id.cv_1);
    }
}