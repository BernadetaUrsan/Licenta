package com.example.licenta.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.TeacherModel;
import com.example.licenta.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendMailActivity extends AppCompatActivity {
    private EditText subiectEt, messageEt;
    private String subiect, mesaj;
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
        FirebaseHelper.teachersDatabase.child(UUID.randomUUID().toString()).setValue(new TeacherModel("Ana DAN", "ursan.bernadeta@gmail.com", "0760234123"));
        getData();
        String[] TO = {"ursan.bernadeta@gmail.com"};

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
    }

    public void OnChooseProf(View view) {
        List<TeacherModel> teachers = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a color");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
            }
        });

        builder.show();
    }
}
