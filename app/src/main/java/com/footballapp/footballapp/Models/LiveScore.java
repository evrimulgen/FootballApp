package com.footballapp.footballapp.Models;

public class LiveScore {
    private int id;
    private String homeName;
    private String awayName;
    private String score;
    private String ftScore;
    private String htScore;
    private String etScore;
    private String time;
    private int leagueId;
    private String status;
    private int homeId;
    private int awayId;

    public LiveScore(int id, String homeName, String awayName, String score, String ftScore, String htScore, String etScore, String time, int leagueId, String status, int homeId, int awayId) {
        this.id = id;
        this.homeName = homeName;
        this.awayName = awayName;
        this.score = score;
        this.ftScore = ftScore;
        this.htScore = htScore;
        this.etScore = etScore;
        this.time = time;
        this.leagueId = leagueId;
        this.status = status;
        this.homeId = homeId;
        this.awayId = awayId;
    }

    public int getId() {
        return id;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public String getScore() {
        return score;
    }

    public String getFtScore() {
        return ftScore;
    }

    public String getHtScore() {
        return htScore;
    }

    public String getEtScore() {
        return etScore;
    }

    public String getTime() {
        return time;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getStatus() {
        return status;
    }

    public int getHomeId() {
        return homeId;
    }

    public int getAwayId() {
        return awayId;
    }

    public String toString(){
        return homeName + " " + score + " " + awayName;
    }
}
