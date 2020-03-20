package com.example.licenta.Models;

public class LocationModel {

    public String numeLocatie;
    public double latitude;
    public double longitude;

    public LocationModel(String numeLocatie, double latitude, double longitude) {
        this.numeLocatie = numeLocatie;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationModel(){

    }

    public String getNumeLocatie() {
        return numeLocatie;
    }

    public void setNumeLocatie(String numeLocatie) {
        this.numeLocatie = numeLocatie;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
