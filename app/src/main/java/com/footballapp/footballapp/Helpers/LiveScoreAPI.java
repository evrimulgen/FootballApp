package com.footballapp.footballapp.Helpers;

import android.util.Log;

import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.Fixture;
import com.footballapp.footballapp.Models.League;
import com.footballapp.footballapp.Models.LiveScore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LiveScoreAPI {

    /**
     * API at http://livescore-api.com
     */
    public static final String API_KEY = "nJTVrvDI1vidH0lc";
    public static final String API_SECRET = "gsEgIMCiV56euphR8aNAGqiIWAVEBhQS";

    public LiveScoreAPI(){
        String authenticationUrl = "http://livescore-api.com/api-client/users/pair.json?key=" + API_KEY + "&secret=" + API_SECRET;


        new HttpTask().execute("http://livescore-api.com/api-client/users/pair.json?key=nJTVrvDI1vidH0lc&secret=gsEgIMCiV56euphR8aNAGqiIWAVEBhQS");
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/6/getting_livescores
     *
     * @return a list of all live matches
     */
    public static ArrayList<LiveScore> getLivescores(){
        String result = "";
        ArrayList<LiveScore> liveScores = new ArrayList<>();
        try {
            result = (new HttpTask().execute("http://livescore-api.com/api-client/scores/live.json?key=" + API_KEY + "&secret=" + API_SECRET)).get();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(result);

            if ((boolean) json.get("success")) {
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("match");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    int id = Integer.parseInt((String) jsonObject.get("id"));
                    String homeName = (String) jsonObject.get("home_name");
                    String awayName = (String) jsonObject.get("away_name");
                    String score = (String) jsonObject.get("score");
                    String htScore = (String) jsonObject.get("ht_score");
                    String ftScore = (String) jsonObject.get("ft_score");
                    String etScore = (String) jsonObject.get("et_score");
                    String time = (String) jsonObject.get("time");
                    int leagueId = Integer.parseInt((String) jsonObject.get("league_id"));
                    String status = (String) jsonObject.get("status");
                    int homeId = Integer.parseInt((String) jsonObject.get("home_id"));
                    int awayId = Integer.parseInt((String) jsonObject.get("away_id"));

                    LiveScore liveScore = new LiveScore(id,homeName,awayName,score,ftScore,htScore,etScore,time,leagueId,status,homeId,awayId);
                    liveScores.add(liveScore);
                    Log.d("FIXTURE", liveScore.toString());
                }
            } else {
                Log.e("Json not successful", "damnit");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liveScores;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/13/getting-scheduled-games
     *
     * @return a list of all fixtures (max 30)
     */
    public static ArrayList<Fixture> getFixtures() {
        String result = "";
        ArrayList<Fixture> fixtures = new ArrayList<>();
        try {
            result = (new HttpTask().execute("http://livescore-api.com/api-client/fixtures/matches.json?key=" + API_KEY + "&secret=" + API_SECRET)).get();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(result);

            if ((boolean) json.get("success")) {
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("fixtures");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String round = (String) jsonObject.get("round");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = dateFormat.parse((String) jsonObject.get("date"));
                    String homeName = (String) jsonObject.get("home_name");
                    String awayName = (String) jsonObject.get("away_name");
                    String location = (String) jsonObject.get("location");
                    int leagueId = Integer.parseInt((String) jsonObject.get("league_id"));


                    Fixture fixture = new Fixture(date, round, homeName, awayName, location, leagueId);
                    fixtures.add(fixture);
                    Log.d("FIXTURE", fixture.toString());
                }
            } else {
                Log.e("Json not successful", "damnit");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fixtures;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/13/getting-scheduled-games
     *
     * @return a list of all fixtures on specific date
     */
    public static ArrayList<Fixture> getFixtures(Date date){
        String result = "";
        ArrayList<Fixture> fixtures = new ArrayList<>();
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result = (new HttpTask().execute("http://livescore-api.com/api-client/fixtures/matches.json?key=" + API_KEY + "&secret=" + API_SECRET + "&date=" + dateFormat.format(date))).get();

            JSONParser parser = new JSONParser();
            JSONObject json =  (JSONObject) parser.parse(result);

            if((boolean) json.get("success")){
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("fixtures");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String round = (String) jsonObject.get("round");
                    date = dateFormat.parse((String) jsonObject.get("date"));
                    String homeName = (String) jsonObject.get("home_name");
                    String awayName = (String) jsonObject.get("away_name");
                    String location = (String) jsonObject.get("location");
                    int leagueId = Integer.parseInt((String) jsonObject.get("league_id"));



                    Fixture fixture = new Fixture(date, round, homeName, awayName, location, leagueId);
                    fixtures.add(fixture);
                    Log.d("FIXTURE", fixture.toString());
                }
            }else {
                Log.e("Json not successful", "damnit");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return fixtures;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/13/getting-scheduled-games
     *
     * @return a list of all fixtures from a specific league
     */
    public static ArrayList<Fixture> getFixtures(int leagueId){
        String result = "";
        ArrayList<Fixture> fixtures = new ArrayList<>();
        try{
            result = (new HttpTask().execute("http://livescore-api.com/api-client/fixtures/matches.json?key=" + API_KEY + "&secret=" + API_SECRET + "&league=" + leagueId)).get();

            JSONParser parser = new JSONParser();
            JSONObject json =  (JSONObject) parser.parse(result);

            if((boolean) json.get("success")){
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("fixtures");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String round = (String) jsonObject.get("round");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = dateFormat.parse((String) jsonObject.get("date"));
                    String homeName = (String) jsonObject.get("home_name");
                    String awayName = (String) jsonObject.get("away_name");
                    String location = (String) jsonObject.get("location");
                    leagueId = Integer.parseInt((String) jsonObject.get("league_id"));



                    Fixture fixture = new Fixture(date, round, homeName, awayName, location, leagueId);
                    fixtures.add(fixture);
                    Log.d("FIXTURE", fixture.toString());
                }
            }else {
                Log.e("Json not successful", "damnit");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return fixtures;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/10/getting-countries-list
     *
     * @return a list of all countries
     */
    public static ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        String result = "";
        try{
            result = (new HttpTask().execute("http://livescore-api.com/api-client/countries/list.json?key=" + API_KEY + "&secret=" + API_SECRET)).get();

            JSONParser parser = new JSONParser();
            JSONObject json =  (JSONObject) parser.parse(result);

            if((boolean) json.get("success")){
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("country");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    int id = Integer.parseInt((String) jsonObject.get("id"));
                    String name = (String) jsonObject.get("name");
                    int isReal = Integer.parseInt((String) jsonObject.get("is_real"));

                    Country country = new Country(id, name, isReal);
                    countries.add(country);
                    Log.d("Country", country.getCountryCode() + ", " + country.getName());
                }
            }else {
                Log.e("Json not successful", "damnit");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return countries;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/11/getting-leagues-list
     *
     * @return a list of all leagues
     */
    public static ArrayList<League> getLeagues(){
        ArrayList<League> leagues = new ArrayList<>();
        String result = "";
        try{
            result = (new HttpTask().execute("http://livescore-api.com/api-client/leagues/list.json?key=" + API_KEY + "&secret=" + API_SECRET)).get();

            JSONParser parser = new JSONParser();
            JSONObject json =  (JSONObject) parser.parse(result);

            if((boolean) json.get("success")){
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("league");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    int id = Integer.parseInt((String) jsonObject.get("id"));
                    String name = (String) jsonObject.get("name");
                    int countryId = Integer.parseInt((String) jsonObject.get("country_id"));

                    League league = new League(id, name, countryId);
                    leagues.add(league);
                    Log.d("League", league.getName());
                }
            }else {
                Log.e("Json not successful", "damnit");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return leagues;
    }

    /**
     * Documented at http://livescore-api.com/documentation/reference/11/getting-leagues-list
     *
     * @return a list of all leagues in a specific country
     */
    public static ArrayList<League> getLeagues(int countryId){
        ArrayList<League> leagues = new ArrayList<>();
        String result = "";
        try{
            result = (new HttpTask().execute("http://livescore-api.com/api-client/leagues/list.json?key=" + API_KEY + "&secret=" + API_SECRET + "&country=" + countryId)).get();
            JSONParser parser = new JSONParser();
            JSONObject json =  (JSONObject) parser.parse(result);

            if((boolean) json.get("success")){
                JSONObject data = (JSONObject) json.get("data");
                JSONArray jsonArray = (JSONArray) data.get("league");

                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    int id = Integer.parseInt((String) jsonObject.get("id"));
                    String name = (String) jsonObject.get("name");
                    countryId = Integer.parseInt((String) jsonObject.get("country_id"));

                    League league = new League(id, name, countryId);
                    leagues.add(league);
                    Log.d("League", league.getName());
                }
            }else {
                Log.e("Json not successful", "damnit");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return leagues;
    }
}
