package com.example.licenta.Activities;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.BuildConfig;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.example.licenta.viewModels.LoginViewModel;
import com.example.licenta.viewModels.LoginViewModelFactory;
import com.example.licenta.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements LoginCallbacks {
    private FirebaseAuth mAuth;
    private EditText emailEt;
    private EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));

        if (BuildConfig.DEBUG)
        {
            emailEt.setText("berna@classboard.com");
            passwordEt.setText("cosmin");
        }

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
        FirebaseHelper.usersDatabase.child("LO610275").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setData(dataSnapshot.getValue(StudentModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setData(StudentModel student)
    {
        UserHelper.Instance().setStudent(student);
        Intent myInt=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(myInt);
    }

    private void initializeViews()
    {
        emailEt = findViewById(R.id.et_username);
        passwordEt = findViewById(R.id.et_password);
    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onFailure() {

    }
}
