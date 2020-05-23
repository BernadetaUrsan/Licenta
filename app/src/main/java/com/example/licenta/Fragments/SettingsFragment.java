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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Set;

public class SettingsFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private Switch aSwitch;
    private TextView aTextView;

    private StudentModel userCurent;
    private ImageView saveBtn, cancelBtn;
    private EditText email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_settings, container, false);
        initializeViews(rootView);
        SetValues();
        aSwitch.setChecked(UserHelper.Instance().getStudent().isNotificationsActivated());
        aSwitch.setOnCheckedChangeListener(this);

        return rootView;
    }

    private void SetValues(){
        userCurent = UserHelper.Instance().getStudent();
        email.setText(userCurent.getEmail());
    }

    private void initializeViews(View view)
    {
        aSwitch = view.findViewById(R.id.switch1);
        aTextView = view.findViewById(R.id.tv_on_off);
        email = view.findViewById(R.id.et_email_nou);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(aSwitch.isChecked())
        {
            aTextView.setText("Pornite");
            UserHelper.Instance().getStudent().setNotificationsActivated(true);
            FirebaseMessaging.getInstance().subscribeToTopic("pushNotifications");
            FirebaseHelper.getInstance().usersDatabase.child(userCurent.getUserId()).child("notificationsActivated").setValue(UserHelper.Instance().getStudent().isNotificationsActivated());
        }
        else
        {
            UserHelper.Instance().getStudent().setNotificationsActivated(false);
            aTextView.setText("Oprite");
            FirebaseMessaging.getInstance().unsubscribeFromTopic("pushNotifications");
            FirebaseHelper.getInstance().usersDatabase.child(userCurent.getUserId()).child("notificationsActivated").setValue(UserHelper.Instance().getStudent().isNotificationsActivated());
        }
    }


    public void OnCancel() {
        SetValues();
    }

    public void OnSave() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}