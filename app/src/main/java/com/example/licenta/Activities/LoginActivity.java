package com.example.licenta.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void OnSignIn(View view) {
        Intent myInt=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(myInt);
    }

    public void OnSignUp(View view) {
        Intent myInt2= new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(myInt2);
    }
}
