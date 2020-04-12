package com.example.projectekam.Data;

public class IndianCities {
    private String city;
    private String state;
    private String district;

    public IndianCities() {
    }

    public IndianCities(String city, String state, String district) {
        this.city = city;
        this.state = state;
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
