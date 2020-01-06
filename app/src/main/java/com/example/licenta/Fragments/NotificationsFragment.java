package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.licenta.Activities.SendMailActivity;
import com.example.licenta.R;

public class NotificationsFragment extends Fragment {

    private Button sendMail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_notifications, container, false);
        sendMail = rootView.findViewById(R.id.btn_send_mail);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSendMail();
            }
        });
        return rootView;
    }

    public void OnSendMail() {
        Intent myInt2= new Intent(getContext(), SendMailActivity.class);
        startActivity(myInt2);
    }

}