package com.example.licenta.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.licenta.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onResume(){
        super.onResume();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent myInt= new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(myInt);
            }
        }, 2000);

    }
}
