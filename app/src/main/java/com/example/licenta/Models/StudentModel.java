package com.example.licenta.Models;

public class StudentModel {
    private String name;
    private String surname;
    private String number;
    private String phoneNumber;
    private String imageUrl;
    private String carId;
    private String email;
    private String fullName;

    public StudentModel(String name, String surname, String number, String phoneNumber, String imageUrl, String carId, String email, String fullName){
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.carId = carId;
        this.email = email;
        this.fullName = fullName;
    }

    public StudentModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        setFullName(name,surname);
        return fullName;
    }

    public void setFullName(String name, String surname) {
        this.fullName = name + " " + surname;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
