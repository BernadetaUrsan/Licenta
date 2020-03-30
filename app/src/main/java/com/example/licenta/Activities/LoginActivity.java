package com.example.licenta.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Interfaces.LoginCallbacks;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements LoginCallbacks {
    private FirebaseAuth mAuth;
    private EditText emailEt;
    private EditText passwordEt;
    private ShareDialog shareDialog;
    private String userEmail;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
//        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//        loginBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this, this)).get(LoginViewModel.class));
        //shareDialog = new ShareDialog(this);  // initialize facebook shareDialog.

    }
    public void onSignIn(String email, String password)
    {
        userEmail = email;
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword("berna3@classboard.com", "cosmin")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            onSignInSuccesful();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onSignInSuccesful()
    {
        FirebaseHelper.getInstance().usersDatabase.child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StudentModel myUser = dataSnapshot.getValue(StudentModel.class);
                UserHelper.Instance().setStudent(myUser);
                UserHelper.Instance().setFirebaseUser(mAuth.getCurrentUser());
                UserHelper.Instance().setLoggedIn(true);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
    }

    public void onSignIn(View view) {
        onSignIn(userEmail, userPassword);
    }
}
