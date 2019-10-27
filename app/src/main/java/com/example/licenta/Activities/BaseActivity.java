package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.licenta.R;

public class BaseActivity extends AppCompatActivity {

    public ImageView backButton;
    public RelativeLayout toolbar;
    public TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initializeBackButton();
        toolbar = findViewById(R.id.toolbar_with_back_button);
        if(toolbar != null)
        {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorToolbar));
        }
    }

    public void setToolbarTitle(String title)
    {
        titleTv = findViewById(R.id.tv_toolbar_title);
        titleTv.setText(title);
    }

    private void initializeBackButton()
    {
        backButton = findViewById(R.id.iv_toolbar_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
