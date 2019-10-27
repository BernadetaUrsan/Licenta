package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.licenta.Activities.HomeActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Activities.ParkingActivity;
import com.example.licenta.Activities.SignUpActivity;
import com.example.licenta.Activities.YearGroupActivity;
import com.example.licenta.R;

public class HomeFragment extends Fragment {

    private CardView yearGroupV;
    private CardView parkingsV;

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

        parkingsV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt3 = new Intent(getActivity(), ParkingActivity.class);
                startActivity(myInt3);
            }
        });
        return rootView;
    }

    private void initializeViews(View view){
        yearGroupV = view.findViewById(R.id.cv_year);
        parkingsV = view.findViewById(R.id.cv_park);
    }
}