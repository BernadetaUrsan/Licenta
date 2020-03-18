package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class SchedulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);
    }

    public void OnBiblioteca (View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pg/UPTLibrary/about/?ref=page_internal"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    public void OnRectorat (View view){

        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upt.ro/Informatii_program-de-lucru_204_ro.html"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnSport (View view){

        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/10JXbruzO2NDYSdXhwFSPRDabVosIiz0FB7yob66NCoI/edit?fbclid=IwAR22d7Z3EZCMupr8fXwGstDIJlCUMV9zF40JRId8niw8wt0l6aTfbevLpSA#gid=1239873235"));
        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent3);
    }

    public void OnBazin (View view){

        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ligaac.ro/node/830"));
        intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent4);
    }
}
