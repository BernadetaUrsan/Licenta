package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.licenta.R;

public class OnePostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);
        super.setToolbarTitle("Year group");
    }
}
