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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements LoginCallbacks {
    private FirebaseAuth mAuth;
    private TextInputEditText emailEt;
    private TextInputLayout emailTil;
    private TextInputEditText passwordEt;
    private TextInputLayout passwordTil;
    private String userEmail;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
    }

    public void onSignIn(String email, String password)
    {
        mAuth = FirebaseAuth.getInstance();
        if(email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "E-mail sau parolă necompletate", Toast.LENGTH_SHORT).show();
        }
        else
            {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                onSignInSuccesful();
                            } else {
                                Toast.makeText(getApplicationContext(), "E-mail sau parolă incorectă",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
    }

    private void onSignInSuccesful()
    {
        FirebaseHelper.getInstance().usersDatabase.child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StudentModel myUser = dataSnapshot.getValue(StudentModel.class);
                UserHelper.Instance().setStudent(myUser);
                UserHelper.Instance().setFirebaseUser(mAuth.getCurrentUser());
                UserHelper.Instance().getStudent().setUserId(mAuth.getCurrentUser().getUid());
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
        userEmail = emailEt.getText().toString();
        userPassword = passwordEt.getText().toString();
        onSignIn(userEmail, userPassword);
    }

    public void onSignUp(View view){
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }
}
