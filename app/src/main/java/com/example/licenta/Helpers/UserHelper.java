package com.example.licenta.Helpers;

import com.example.licenta.Models.StudentModel;

public class UserHelper {
    private static UserHelper userHelper;
    private StudentModel student;

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
}
