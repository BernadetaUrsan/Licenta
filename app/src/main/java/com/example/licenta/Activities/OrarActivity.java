package com.example.licenta.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.licenta.Adapters.TimetableAdapter;
import com.example.licenta.R;

public class OrarActivity extends AppCompatActivity {

    TextView luni, marti, miercuri, joi, vineri;
    private TimetableAdapter listaZi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orar);

        initializeViews();
        Fragment fragment = null;
    }


    public void OnLuni (View view){
        luni.setTextSize(26);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
//        fragment = fragmentLuni;
//        return LoadFragment(fragment);
    }

    public void OnMarti (View view){

        luni.setTextSize(16);
        marti.setTextSize(26);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(16);
//        fragment = fragmentMarti;
//        return LoadFragment(fragment);
    }

    public void OnMiercuri (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(26);
        joi.setTextSize(16);
        vineri.setTextSize(16);
//        fragment = fragmentMiercurii;
//        return LoadFragment(fragment);
    }

    public void OnJoi (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(26);
        vineri.setTextSize(16);
//        fragment = fragmentJoi;
//        return LoadFragment(fragment);
    }

    public void OnVineri (View view){

        luni.setTextSize(16);
        marti.setTextSize(16);
        miercuri.setTextSize(16);
        joi.setTextSize(16);
        vineri.setTextSize(26);
//        fragment = fragmentVineri;
//        return LoadFragment(fragment);
    }

    private void initializeViews(){
        luni = findViewById(R.id.tv_luni);
        marti = findViewById(R.id.tv_marti);
        miercuri = findViewById(R.id.tv_miercuri);
        joi = findViewById(R.id.tv_joi);
        vineri = findViewById(R.id.tv_vineri);


//        fragmentLuni=new LuniFragment();
//        fragmentMarti=new MartiFragment();
//        fragmentMiercuri=new MiercuriFragment();
//        fragmentJoi=new JoiiFragment();
//        fragmentVineri=new VineriFragment();

    }

//    private boolean LoadFragment(Fragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//            return true;
//        } else
//            return false;
//    }
}
