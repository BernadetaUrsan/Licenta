package com.example.licenta.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.R;
import com.example.licenta.databinding.ActivityLoginBinding;
import com.example.licenta.viewModels.LoginViewModel;
import com.example.licenta.viewModels.LoginViewModelFactory;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements LoginCallbacks {
    private FirebaseAuth mAuth;
    private EditText emailEt;
    private EditText passwordEt;
    private ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this, this)).get(LoginViewModel.class));
        shareDialog = new ShareDialog(this);  // initialize facebook shareDialog.
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

    public void shareOnFacebook(View view) {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Android Facebook Integration and Login Tutorial")
                    .setQuote("Testing test")
                    .setImageUrl(Uri.parse("https://www.studytutorial.in/wp-content/uploads/2017/02/FacebookLoginButton-min-300x136.png"))
                                   .setContentUrl(Uri.parse("https://www.studytutorial.in/android-facebook-integration-and-login-tutorial"))
                                                                    .build();
            shareDialog.show(linkContent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
    }
}
