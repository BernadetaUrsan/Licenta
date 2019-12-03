package com.example.licenta.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.licenta.Interfaces.loginCommand;
import com.example.licenta.Models.StudentModel;

public class LoginViewModel extends AndroidViewModel implements loginCommand {
    private String userEmail;
    private String userPassword;
    private StudentModel student;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public void onLoginClicked() {

    }
}
