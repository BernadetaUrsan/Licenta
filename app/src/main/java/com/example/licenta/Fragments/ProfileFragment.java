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

import com.example.licenta.Activities.EditProfileActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.R;

public class ProfileFragment extends Fragment {
    private Button signOutBtn, editProfileBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        InitializeViews(view);
        setBtnActions();

        return view;
    }

    private void InitializeViews(View view) {
        signOutBtn= view.findViewById(R.id.btn_signout);
        editProfileBtn= view.findViewById(R.id.btn_edit);
    }

    private void setBtnActions(){
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSignOut();
            }
        });

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnEditProfile();
            }
        });
    }

    public void OnSignOut() {
        Intent myInt= new Intent(getActivity(), LoginActivity.class);
        startActivity(myInt);
    }

    public void OnEditProfile() {
        Intent myInt= new Intent(getActivity(), EditProfileActivity.class);
        startActivity(myInt);
    }
}
