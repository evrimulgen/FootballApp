package com.footballapp.footballapp.Models;

public class League {
    private int id;
    private String name;
    private int countryId;

    public League(int id, String name, int countryId) {

        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountryId() {
        return countryId;
    }
}
