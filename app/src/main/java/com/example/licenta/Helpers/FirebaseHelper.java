package com.example.licenta.Helpers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public static DatabaseReference yearGroupPostsDatabase = firebaseDatabase.getReference("YearPosts");
    public static DatabaseReference postCommentsDatabase = firebaseDatabase.getReference("Comments");
    public static DatabaseReference usersDatabase = firebaseDatabase.getReference("Users");
    public static FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public static FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    public static FirebaseHelper Instance()
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
