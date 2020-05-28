package com.example.licenta.Helpers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference yearGroupPostsDatabase = firebaseDatabase.getReference("YearPosts");
    public DatabaseReference postCommentsDatabase = firebaseDatabase.getReference("Comments");
    public DatabaseReference usersDatabase = firebaseDatabase.getReference("Users");
    public DatabaseReference teachersDatabase = firebaseDatabase.getReference("Teachers");
    public DatabaseReference timetableDatabase = firebaseDatabase.getReference("Timetable");
    public FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    public StorageReference contractStudii = FirebaseStorage.getInstance().getReference("ContracteStudii");
    public DatabaseReference calendarDatabase = firebaseDatabase.getReference("Calendar");

    public static FirebaseHelper getInstance()
    {
        if(firebaseHelper == null)
        {
            firebaseHelper = new FirebaseHelper();
        }
        return firebaseHelper;
    }

    private FirebaseHelper()
    {
    }

}
