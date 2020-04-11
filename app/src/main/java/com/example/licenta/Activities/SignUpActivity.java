package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEt;
    private EditText parolaEt;
    private EditText numeEt;
    private EditText prenumeEt;
    private EditText matricolEt;
    private EditText telefonEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onSignUp(View view){

    }

    private void writeNewUser(String nume, String prenume, String matricol, String telefon, String email) {
        StudentModel user = new StudentModel(nume, prenume, matricol, telefon, " ", " ", email, " ");

    }

    private void initializeViews()
    {
        emailEt = findViewById(R.id.et_email);
        parolaEt = findViewById(R.id.et_parola);
        numeEt = findViewById(R.id.et_nume);
        prenumeEt = findViewById(R.id.et_prenume);
        matricolEt = findViewById(R.id.et_matricol);
        telefonEt = findViewById(R.id.et_telefon);
    }
}
