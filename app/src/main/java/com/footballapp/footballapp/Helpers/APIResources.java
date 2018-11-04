package com.footballapp.footballapp.Helpers;

import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.Fixture;
import com.footballapp.footballapp.Models.League;
import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.Models.Odds;

import java.util.ArrayList;

public class APIResources {

    private static ArrayList<Country> countries = LiveScoreAPI.getCountries();
    private static ArrayList<com.footballapp.footballapp.Models.LiveScore> LiveScore = LiveScoreAPI.getLivescores();
    private static ArrayList<League> leagues = LiveScoreAPI.getLeagues();
    private static ArrayList<Odds> odds = OddsAPI.getOdds();


    public static ArrayList<Country> getCountries() {
        return countries;
    }

    public static Country getCountry(int countryId){
        for(Country country : countries){
            if(country.getId() == countryId)
                return country;
        }
        return null;
    }

    public static ArrayList<LiveScore> getLiveScore() {
        return LiveScore;
    }

    public static ArrayList<League> getLeagues() {
        return leagues;
    }

    public static ArrayList<League> getLeagues(int countryId){
        if(countryId < 0){
            return getLeagues();
        }
        return LiveScoreAPI.getLeagues(countryId);
    }

    public static ArrayList<Odds> getOdds(){
        return odds;
    }

    public static ArrayList<Fixture> getFixtures(int leagueId){
//        To open new fixture fragment
//
//        FixturesFragment ff = new FixturesFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("leagueId", 114);
//        ff.setArguments(bundle);

        return LiveScoreAPI.getFixtures(leagueId);
    }

}
