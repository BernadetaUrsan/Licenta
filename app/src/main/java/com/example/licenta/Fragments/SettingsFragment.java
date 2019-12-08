package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.licenta.Activities.HomeActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Activities.SendMailActivity;
import com.example.licenta.Activities.SignUpActivity;
import com.example.licenta.R;

public class SettingsFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_settings, container, false);

        return rootView;
    }

    public void OnSendMail(View view) {
        Intent myInt2= new Intent(getActivity(), SendMailActivity.class);
        startActivity(myInt2);
    }
}