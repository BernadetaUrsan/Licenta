package com.example.licenta.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class ContractStudiiActivity extends BaseActivity {

    private static final int GALLERY_REQUEST_CODE=123;
    private ImageView imageView;
    private Button buttonAdd, buttonSave;
    private StorageTask uploadTask;
    private Uri imageData;

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

    private String getFileExtension(Uri uri)
    {
        ContentResolver mContentResolver = this.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(mContentResolver.getType(uri));
    }

    public void OnSaveContract(View view){

        final StorageReference fileReference = FirebaseHelper.getInstance().contractStudii.child(UserHelper.Instance().getStudent().getUserId()+"."+getFileExtension(imageData));
        uploadTask = fileReference.putFile(imageData);
        uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful())
                {
                    throw task.getException();
                }
                return fileReference.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful())
                {
                    Uri downloadUri = task.getResult();
                    String mUri = downloadUri.toString();
                    imageList.add(mUri);
                }
                else
                {
                    Toast.makeText(ContractStudiiActivity.this, "Failed upload", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ContractStudiiActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            imageData = data.getData();

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
