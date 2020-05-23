package com.example.licenta.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.licenta.R;

public class ContractStudiiActivity extends BaseActivity {

    private static final int GALLERY_REQUEST_CODE=123;
    ImageView imageView;
    Button buttonAdd, buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_studii);
        setToolbarTitle("Contract de studii");
        initializeViews();
    }

    public void OnAddContract(View view){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/^");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Adaugă contractul"),GALLERY_REQUEST_CODE);
            }
        });
    }

    public void OnSaveContract(View view){


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri imageData = data.getData();

            imageView.setImageURI(imageData);
            buttonSave.setVisibility(View.VISIBLE);
        }
    }

    private void initializeViews(){
        imageView = findViewById(R.id.iv_poza_contract);
        buttonAdd = findViewById(R.id.btn_add_contract);
        buttonSave = findViewById(R.id.btn_save_contract);
    }
}
