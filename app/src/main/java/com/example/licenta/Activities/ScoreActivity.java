package com.example.licenta.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.licenta.R;
import com.example.licenta.ViewModels.ScoreViewModel;

public class ScoreActivity extends AppCompatActivity {

    private ScoreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
    }

    public void onTestClick(View view) {
        viewModel.scoreA++;
        viewModel.scoreB+=2;
    }
}
