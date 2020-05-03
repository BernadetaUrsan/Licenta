package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class NewsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setToolbarTitle("Informații");
    }

    public void OnRegulamente(View view){
        Intent myInt= new Intent(NewsActivity.this, RegulamenteActivity.class);
        startActivity(myInt);
    }

    public void OnStructura(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ac.upt.ro/uploads/structura-anului-universitar-2019-2020.pdf"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    public void OnPractica(View view){
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ac.upt.ro/uploads/practica2015/ghid-practica.pdf"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnExamene(View view){
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/10Txn1y2aHZNRqJnJ-zSWDQ75V1fp_Ip9Mxl00aJ8R_o/edit#gid=1273101482"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnOptionale(View view){
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ac.upt.ro/alegere_optionale.php#top"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnSecretariat(View view){
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ac.upt.ro/contact.php#top"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnP3(View view){
        Intent myInt= new Intent(NewsActivity.this, P3Activity.class);
        startActivity(myInt);
    }
}
