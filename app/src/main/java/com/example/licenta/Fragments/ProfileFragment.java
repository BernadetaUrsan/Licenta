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
import android.widget.EditText;
import android.widget.ImageView;

import com.example.licenta.Activities.EditProfileActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private StudentModel userCurent;
    private ImageView signOutBtn, editProfileBtn;
    private EditText nume, prenume, telefon, matricol, numeComplet;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        InitializeViews(view);
        SetValues();
        setBtnActions();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SetValues();
    }

    private void SetValues(){

        userCurent = UserHelper.Instance().getStudent();
        numeComplet.setText(userCurent.getFullName());
        telefon.setText(userCurent.getPhoneNumber());
        matricol.setText(userCurent.getNumber());
    }

    private void InitializeViews(View view) {
        editProfileBtn= view.findViewById(R.id.iv_edit);
        signOutBtn= view.findViewById(R.id.iv_log_out);

        numeComplet = view.findViewById(R.id.et_nume_complet);
        matricol=view.findViewById(R.id.et_matricol);
        telefon=view.findViewById(R.id.et_telefon);
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
        FirebaseAuth.getInstance().signOut();

        userCurent = null;

        Intent myInt= new Intent(getActivity(), LoginActivity.class);
        startActivity(myInt);
    }

    public void OnEditProfile() {
        Intent myInt= new Intent(getActivity(), EditProfileActivity.class);
        startActivity(myInt);
    }
}
