package com.example.licenta.Helpers;

import com.example.licenta.Models.StudentModel;
import com.google.firebase.auth.FirebaseUser;

public class UserHelper {
    private static UserHelper userHelper;
    private StudentModel student;
    private static FirebaseUser firebaseUser;
    private boolean isLoggedIn;

    private UserHelper(){

    }

    public static UserHelper Instance()
    {
        if(userHelper == null)
        {
            userHelper = new UserHelper();
        }
        return userHelper;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public String getFullName()
    {
        return  student.getSurname().concat(" ").concat(student.getName());
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    public static boolean isUserSet()
    {
        return firebaseUser != null;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
