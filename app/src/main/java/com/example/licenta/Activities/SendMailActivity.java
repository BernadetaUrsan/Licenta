package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.licenta.Adapters.TeacherDialogAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.TeacherModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendMailActivity extends AppCompatActivity {
    private EditText subiectEt, messageEt;
    private String subiect, mesaj;
    private TextView teacherTv;
    private TeacherModel selectedTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
        initializeViews();
    }

    private void getData()
    {
        subiect = subiectEt.getText().toString();
        mesaj = messageEt.getText().toString();
    }

    public void OnSend(View view) {
        getData();
        String teacherEmail = selectedTeacher.getEmail();
        if (teacherEmail == null || teacherEmail.isEmpty())
        {
            Toast.makeText(this, "Selectează un profesor pentru a trimite mail", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] TO = {selectedTeacher.getEmail()};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subiect);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mesaj);

        try {
            startActivity(Intent.createChooser(emailIntent, "Sending mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SendMailActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeViews()
    {
        subiectEt = findViewById(R.id.et_email_subiect);
        messageEt = findViewById(R.id.et_email_mesaj);
        teacherTv = findViewById(R.id.tv_email_prof);
    }

    public void OnChooseProf(View view) {
        final List<TeacherModel> teachers = new ArrayList<>();
        FirebaseHelper.teachersDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                        teachers.add(data.getValue(TeacherModel.class));
                }
                setDialog(teachers);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setDialog(List<TeacherModel> teachers)
    {
        final Dialog dialog = new Dialog(this);
        View rootView = getLayoutInflater().inflate(R.layout.teacher_dialog_adapter, null);
        final ListView lv = rootView.findViewById(R.id.dialogListView);
        TeacherDialogAdapter aba = new TeacherDialogAdapter(SendMailActivity.this, teachers);
        lv.setAdapter(aba);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                selectedTeacher = (TeacherModel) lv.getItemAtPosition(arg2);
                teacherTv.setText(selectedTeacher.getName());
                dialog.dismiss();

            }
        });
        dialog.setContentView(rootView);
        dialog.show();
    }
}
