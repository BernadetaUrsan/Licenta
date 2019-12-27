package com.example.licenta.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.licenta.Activities.LoginActivity;
import com.example.licenta.Interfaces.LoginCallbacks;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginCallbacks loginCallbacks;
    private Context context;

    public LoginViewModelFactory(LoginCallbacks loginCallbacks, LoginActivity loginActivity) {
        this.loginCallbacks = loginCallbacks;
        this.context = loginActivity;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginCallbacks, context);
    }
}
