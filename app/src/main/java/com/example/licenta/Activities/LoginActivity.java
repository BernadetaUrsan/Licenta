package com.example.licenta.Activities;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailEt;
    private EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void OnSignIn(View view) {
        String email = String.valueOf(emailEt.getText());
        String password = String.valueOf(passwordEt.getText());
        onSignIn(email, password);
    }

    public void OnSignUp(View view) {
        Intent myInt2= new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(myInt2);
    }

    private void onSignIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            onSignInSuccesful();
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onSignInSuccesful()
    {
        Intent myInt=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(myInt);
    }

    private void initializeViews()
    {
        emailEt = findViewById(R.id.et_username);
        passwordEt = findViewById(R.id.et_password);
    }
}
