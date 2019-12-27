package com.example.licenta.Activities;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.R;
import com.example.licenta.databinding.ActivityLoginBinding;
import com.example.licenta.viewModels.LoginViewModel;
import com.example.licenta.viewModels.LoginViewModelFactory;
import com.google.firebase.auth.FirebaseAuth;

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
        loginBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this, this)).get(LoginViewModel.class));
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
