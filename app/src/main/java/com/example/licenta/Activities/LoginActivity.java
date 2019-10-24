package com.example.licenta.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
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
