package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.licenta.Adapters.TeacherDialogAdapter;
import com.example.licenta.Fragments.TimePickerFragment;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.TeacherModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddEventActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private EditText eventEt;
    private String descriere;
    private TextView picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        initializeViews();
        picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });
    }

    private void getData()
    {
        descriere = eventEt.getText().toString();
    }

    private void initializeViews()
    {
        eventEt = findViewById(R.id.et_event_name);
        picker = findViewById(R.id.tv_pick_time);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        picker.setText("Ora "+ hourOfDay + " : "+ minute);
    }
}
