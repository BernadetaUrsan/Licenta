package com.example.licenta.viewModels;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.Models.StudentModel;

public class LoginViewModel extends ViewModel {
    private String userEmail;
    private String userPassword;
    private StudentModel student;
    private LoginCallbacks loginCallbacks;

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

    public LoginViewModel(LoginCallbacks loginCallbacks) {
        this.loginCallbacks = loginCallbacks;
        this.student = new StudentModel();
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
        int a =0;
    }
}
