package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.licenta.Fragments.ProfileFragment;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EditProfileActivity extends AppCompatActivity {

    private StudentModel userCurent;
    private ImageView signOutBtn, editProfileBtn;
    private EditText numeComplet, telefon, matricol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        InitializeViews();
        SetValues();

    }

    private void SetValues(){

        userCurent = UserHelper.Instance().getStudent();
        numeComplet.setText(userCurent.getFullName());
        telefon.setText(userCurent.getPhoneNumber());
        matricol.setText(userCurent.getNumber());
    }

    private void InitializeViews() {
        editProfileBtn= findViewById(R.id.iv_edit);
        signOutBtn= findViewById(R.id.iv_log_out);

        numeComplet = findViewById(R.id.et_nume_complet);
        matricol=findViewById(R.id.et_matricol);
        telefon=findViewById(R.id.et_telefon);
    }

    public void OnSave(View view) {

        FirebaseHelper.getInstance().usersDatabase.child(userCurent.getNumber()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String matricolNou = matricol.getText().toString();
                String telefonNou = telefon.getText().toString();

                UserHelper.Instance().getStudent().setNumber(matricolNou);
                UserHelper.Instance().getStudent().setPhoneNumber(telefonNou);

                HashMap<String, Object> map = new HashMap<>();
                map.put("number", matricolNou);
                map.put("phoneNumber", telefonNou);
                FirebaseHelper.getInstance().usersDatabase.child(userCurent.getNumber()).updateChildren(map);
                OnCancel();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void OnCancel() {
        Toast.makeText(EditProfileActivity.this, "Profil modificat cu succes!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void OnCancel(View view) {
        this.finish();
    }
}
