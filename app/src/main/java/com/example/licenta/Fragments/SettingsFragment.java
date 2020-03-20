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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.licenta.Activities.HomeActivity;
import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Activities.SendMailActivity;
import com.example.licenta.Activities.SignUpActivity;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private Switch aSwitch;
    private TextView aTextView;

    private StudentModel userCurent;
    private ImageView saveBtn, cancelBtn;
    private EditText email, parola;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_settings, container, false);
        initializeViews(rootView);

        aSwitch.setOnCheckedChangeListener(this);

        SetValues();
        setBtnActions();

        return rootView;
    }

    private void SetValues(){

        userCurent = UserHelper.Instance().getStudent();
        email.setText(userCurent.getEmail());
        //parola.setText(userCurent.());
    }

    private void initializeViews(View view)
    {
        aSwitch = view.findViewById(R.id.switch1);
        aTextView = view.findViewById(R.id.tv_on_off);

        saveBtn = view.findViewById(R.id.btn_save);
        cancelBtn = view.findViewById(R.id.btn_cancel);
        email = view.findViewById(R.id.et_email_nou);
        parola = view.findViewById(R.id.et_parola_noua);
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

    private void setBtnActions(){
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSave();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnCancel();
            }
        });
    }

    public void OnCancel() {

        onResume();
    }

    public void OnSave() {

        FirebaseHelper.getInstance().usersDatabase.child(userCurent.getNumber()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String emailNou = email.getText().toString();
//
//                UserHelper.Instance().getStudent().setEmail(emailNou);
//
//                HashMap<String, Object> map = new HashMap<>();
//                map.put("email", emailNou);
//                FirebaseHelper.usersDatabase.child(userCurent.getEmail()).updateChildren(map);
                onResume();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        SetValues();
    }
}