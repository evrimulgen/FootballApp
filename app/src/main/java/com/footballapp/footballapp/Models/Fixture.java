package com.footballapp.footballapp.Models;

import java.util.Date;

public class Fixture {
    private Date date;
    private String round;
    private String homeName;
    private String awayName;
    private String location;
    private int leagueId;

    public Fixture(Date date, String round, String homeName, String awayName, String location, int leagueId) {
        this.date = date;
        this.round = round;
        this.homeName = homeName;
        this.awayName = awayName;
        this.location = location;
        this.leagueId = leagueId;
    }

    public Date getDate() {
        return date;
    }

    public String getRound() {
        return round;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public String getLocation() {
        return location;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String toString(){
        return homeName + " vs. " + awayName;
    }
}
