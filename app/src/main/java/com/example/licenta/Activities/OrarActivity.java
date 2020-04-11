package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.licenta.Adapters.TimetableAdapter;
import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.TimetabelModel;
import com.example.licenta.R;

import java.util.List;

public class OrarActivity extends AppCompatActivity {

    TextView luni, marti, miercuri, joi, vineri;
    private TimetableAdapter listaZi;
    private TimetableAdapter timetableAdapter;
    private List<TimetabelModel> timetableList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);
        initializeViews();
    }


    public void OnLuni (View view){
        luni.setTextSize(26);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
    }

    public void OnMarti (View view){

        luni.setTextSize(16);
        marti.setTextSize(26);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
    }

    public void OnMiercuri (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(26);
        joi.setTextSize(16);
        vineri.setTextSize(16);
    }

    public void OnJoi (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(26);
        vineri.setTextSize(16);
    }

    public void OnVineri (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(26);
    }

    private void initializeViews(){
        luni = findViewById(R.id.tv_luni);
        marti = findViewById(R.id.tv_marti);
        miercuri = findViewById(R.id.tv_miercuri);
        joi = findViewById(R.id.tv_joi);
        vineri = findViewById(R.id.tv_vineri);

        recyclerView= findViewById(R.id.rv_timetable);
    }
}
