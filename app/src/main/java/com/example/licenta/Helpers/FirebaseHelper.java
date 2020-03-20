package com.example.licenta.Helpers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public DatabaseReference yearGroupPostsDatabase = firebaseDatabase.getReference("YearPosts");
    public DatabaseReference postCommentsDatabase = firebaseDatabase.getReference("Comments");
    public DatabaseReference usersDatabase = firebaseDatabase.getReference("Users");
    public DatabaseReference teachersDatabase = firebaseDatabase.getReference("Teachers");
    public FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

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
