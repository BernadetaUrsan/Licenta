package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.R;

public class RegulamenteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulamente);
        setToolbarTitle("Regulamente");
    }

    public void OnBurse(View view){

        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cospol.upt.ro/wp-content/uploads/2017/09/REGULAMENT-BURSE-2017-2018.pdf"));
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent1);
    }

    public void OnTabere(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://upt.ro/img/files/2014-2015/regulamente/stud/Regulament_tabere_2015.pdf"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    public  void OnCazare(View view){

        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upt.ro/img/files/2014-2015/regulamente/stud/Regulament_cazare_2015.pdf"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }

    public void OnEvaluare(View view){

        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upt.ro/pdf/licenta&master/Regulament_UPT_examinare_notare_stud.pdf"));
        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent3);
    }

    public void OnSef(View view){

        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.upt.ro/img/files/inf_publice/Regulament-alegeri-studenti-UPT.pdf"));
        intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent4);
    }
}
