package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class P3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3);
        setToolbarTitle("Plată P3");
    }

    public void OnIS(View view){

        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1a1FSwqWm6H6ebdzz3A8vez2GhscCbXb6raWVLoDlf8w/edit#gid=0"));
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent1);
    }

    public void OnCTI(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1TDbnJixgkKU3XNQlOnhvKDq9nvabw3wcbFJnHYYw-AQ/edit#gid=0"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    public  void OnCTIEng(View view){

        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1Tc0YK5tTE2Sfjd10xzPnfXM5XsNwGI_HsRccORFPF8k/edit#gid=0"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnInfo(View view){

        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1bqq60wUVHfzsdAXoidruIZ4tU9xapZs2pQf4eN3eswU/edit#gid=0"));
        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent3);
    }
}
