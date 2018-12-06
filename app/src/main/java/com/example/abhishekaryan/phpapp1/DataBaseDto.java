package com.example.abhishekaryan.phpapp1;

import android.support.v7.widget.RecyclerView;

public class DataBaseDto{

    private String name;
    private String password;
    private String contact;
    private String country;

    public DataBaseDto(String name, String password, String contact, String country) {
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String getCountry() {
        return country;
    }
}
