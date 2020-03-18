package com.example.licenta.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.licenta.Activities.HomeActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Activities.SendMailActivity;
import com.example.licenta.Activities.SignUpActivity;
import com.example.licenta.R;

public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private Switch aSwitch;
    private TextView aTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_settings, container, false);
        initializeViews(rootView);

        aSwitch.setOnCheckedChangeListener(this);

        return rootView;
    }

    private void initializeViews(View view)
    {
        aSwitch = view.findViewById(R.id.switch1);
        aTextView = view.findViewById(R.id.tv_on_off);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(aSwitch.isChecked())
        {
            aTextView.setText("Pornite");
        }
        else
        {
            aTextView.setText("Oprite");
        }
    }

}