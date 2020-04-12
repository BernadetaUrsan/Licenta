package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;

import java.util.List;

public class FindStudentActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private TextView searchStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_student);

        initializeViews();
    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_students);
        searchStudent = findViewById(R.id.tv_toolbar_title);
    }

    public void OnSearchStudent(View view){
        searchStudent.setVisibility(View.VISIBLE);
    }
}
