package com.footballapp.footballapp.Models;

import android.graphics.Bitmap;

import com.footballapp.footballapp.Helpers.CountryCode;

public class Country {
    private int id;
    private String name;
    private int isReal;
    private String countryCode;
    private Bitmap countryFlag;

    public Country(int id, String name, int isReal) {
        this.id = id;
        this.name = name;
        this.isReal = isReal;
        this.countryCode = CountryCode.Codes.get(name);
        if(countryCode == null){
            if(name.contains("UEFA") | name.contains("Euro"))
                countryCode = "EU";
            else
                countryCode = "SO";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIsReal() {
        return isReal;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public Bitmap getCountryFlag() {
        return countryFlag;
    }
}
