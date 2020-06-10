package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.licenta.Adapters.StudentsAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FindStudentActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private StudentsAdapter studentsAdapter;
    private EditText searchStudent;
    private List<StudentModel> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_student);

        initializeViews();
        getData();
    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_students);
        searchStudent = findViewById(R.id.et_student_cautat);
        searchStudent.setVisibility(View.GONE);
    }

    private void getData(){
        FirebaseHelper.getInstance().usersDatabase.orderByChild("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentsList = new ArrayList<>();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    StudentModel post = data.getValue(StudentModel.class);
                    studentsList.add(post);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                studentsAdapter = new StudentsAdapter(studentsList, getApplicationContext());
                recyclerView.setAdapter(studentsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void OnSearchStudent(View view){
        searchStudent.setVisibility(View.VISIBLE);
        searchStudent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                studentsAdapter.getFilter().filter(searchStudent.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void OnSeeStudentDetail(View view){

    }
}
