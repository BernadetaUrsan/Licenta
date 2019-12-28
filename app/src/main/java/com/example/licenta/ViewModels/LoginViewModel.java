package com.example.licenta.viewModels;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.licenta.Activities.HomeActivity;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.Models.StudentModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginViewModel extends ViewModel {
    private String userEmail;
    private String userPassword;
    private StudentModel student;
    private LoginCallbacks loginCallbacks;
    private FirebaseAuth mAuth;
    private Context context;

    public TextWatcher emailTextWatcher(){
         return new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {
                 userEmail=(s.toString());
             }
         };
    }

    public TextWatcher passwordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userPassword = s.toString();
            }
        };
    }

    public LoginViewModel(LoginCallbacks loginCallbacks, Context context) {
        this.loginCallbacks = loginCallbacks;
        this.context = context;
        this.student = new StudentModel();
        mAuth = FirebaseAuth.getInstance();
    }

    public LoginViewModel() {
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public LoginCallbacks getLoginCallbacks() {
        return loginCallbacks;
    }

    public void setLoginCallbacks(LoginCallbacks loginCallbacks) {
        this.loginCallbacks = loginCallbacks;
    }

    public void onLoginClicked(View view) {
        onSignIn();
    }

    private void onSignIn()
    {
        mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            onSignInSuccesful();
                        }
                        else {
                            Toast.makeText(context, "Authentication failed.",
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
        Intent myInt=new Intent(context, HomeActivity.class);
        context.startActivity(myInt);
    }
}
