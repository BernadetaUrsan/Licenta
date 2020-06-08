package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.StorageHelper;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private StudentModel studentNou;
    private String mUserId;
    private TextInputEditText emailEt;
    private TextInputLayout emailTil;
    private TextInputEditText numeEt;
    private TextInputLayout numeTil;
    private TextInputEditText matricolEt;
    private TextInputLayout matricolTil;
    private TextInputEditText telefonEt;
    private TextInputLayout telefonTil;
    private TextInputEditText prenumeEt;
    private TextInputLayout prenumeTil;
    private TextInputEditText parolaEt;
    private TextInputLayout parolaTil;
    private TextInputEditText confirmParolaEt;
    private TextInputLayout onfirmParolaTil;


    FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        initializeViews();
        mAuth = FirebaseAuth.getInstance();
    }

    public void onSignUp(View view){
        if(emailEt.getText().toString().isEmpty() || parolaEt.getText().toString().isEmpty() || confirmParolaEt.getText().toString().isEmpty() || numeEt.getText().toString().isEmpty() || prenumeEt.getText().toString().isEmpty() || matricolEt.getText().toString().isEmpty() || telefonEt.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Contul nu poate fi creat fără ca toate câmpurile să fie complete", Toast.LENGTH_SHORT).show();
        }
        else{
            if(parolaEt.getText().toString().equals(confirmParolaEt.getText().toString())){
                Register(emailEt.getText().toString(), parolaEt.getText().toString());
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Parolele nu corespund", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Register(final String Email, final String Password){
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Înregistrare cu succes!!", Toast.LENGTH_LONG).show();
                    mUser = mAuth.getCurrentUser();
                    mUserId = mUser.getUid();
                    writeNewUser( numeEt.getText().toString(),prenumeEt.getText().toString(), matricolEt.getText().toString(), telefonEt.getText().toString(),emailEt.getText().toString());
                    Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        });
    }

    private void writeNewUser(String nume, String prenume, String matricol, String telefon, String email) {
        studentNou = new StudentModel(nume, prenume, matricol, telefon, " ", " ", email, " ",false);
        FirebaseHelper.getInstance().usersDatabase.child(mUserId).setValue(studentNou);
        StorageHelper.InitEmptyTimetable(mUserId);
    }

    private void initializeViews()
    {
        emailEt = findViewById(R.id.et_email);
        confirmParolaEt = findViewById(R.id.et_confirmare_parola);
        parolaEt = findViewById(R.id.et_parola);
        numeEt = findViewById(R.id.et_nume);
        prenumeEt = findViewById(R.id.et_prenume);
        matricolEt = findViewById(R.id.et_matricol);
        telefonEt = findViewById(R.id.et_telefon);
    }
}
