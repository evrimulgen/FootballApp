package com.footballapp.footballapp.Models;

public class Odds {
    private String homeName;
    private String awayName;
    private String oddsHome;
    private String oddsDraw;
    private String oddsAway;
    private String oddsSite;

    public Odds(String homeName, String awayName, String oddsHome, String oddsDraw, String oddsAway, String oddsSite) {

        this.homeName = homeName;
        this.awayName = awayName;
        this.oddsHome = oddsHome;
        this.oddsDraw = oddsDraw;
        this.oddsAway = oddsAway;
        this.oddsSite = oddsSite;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public String getOddsHome() {
        return oddsHome;
    }

    public String getOddsDraw() {
        return oddsDraw;
    }

    public String getOddsAway() {
        return oddsAway;
    }

    public String getOddsSite() {
        return oddsSite;
    }
}
