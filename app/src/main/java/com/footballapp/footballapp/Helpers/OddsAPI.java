package com.footballapp.footballapp.Helpers;

import android.util.Log;

import com.footballapp.footballapp.Models.Odds;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class OddsAPI {

    private static final String API_KEY="8f74a83082d31b496e9ddd7cc0c5e94a";

    public static ArrayList<Odds> getOdds(){
        String result = "";
        ArrayList<Odds> odds = new ArrayList<>();
        try {
            result = (new HttpTask().execute("https://api.the-odds-api.com/v3/odds?sport=soccer_epl&region=uk&mkt=h2h&apiKey=" + API_KEY).get());

            Log.d("RESULT JSON", result);

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(result);

            if ((boolean) json.get("success")) {
                JSONArray data = (JSONArray) json.get("data");

                Log.d("TOTAL ODDS", data.size() +"");

                for( int x = 0; x < data.size(); x++){
                    JSONObject object = (JSONObject) data.get(x);
                    JSONArray teams = (JSONArray) object.get("teams");

                    Log.d("TEAMS", teams.toString());

                    String homeName = (String) object.get("home_team");
                    String awayName = "";

                    boolean homeTeamFirst = true;

                    for (int i = 0; i < teams.size(); i++) {
                        String team = (String) teams.get(i);
                        if (!homeName.equals(team)) {
                            awayName = team;
                            if(i == 0){
                                homeTeamFirst = false;
                            }
                        }
                    }

                    String siteName = "";
                    String oddsHome = "";
                    String oddsDraw = "";
                    String oddsAway = "";

                    JSONArray jsonArray = (JSONArray) object.get("sites");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        siteName = (String) jsonObject.get("site_nice");
                        JSONObject oddsObject = (JSONObject) jsonObject.get("odds");
                        JSONArray h2hArray = (JSONArray) oddsObject.get("h2h");

                        try{
                            oddsDraw = String.valueOf(h2hArray.get(2));
                        }catch (Exception ex){

                        }
                        if(homeTeamFirst){
                            oddsHome = String.valueOf(h2hArray.get(0));
                            oddsAway = String.valueOf(h2hArray.get(1));
                        }else{
                            oddsHome = String.valueOf(h2hArray.get(1));
                            oddsAway = String.valueOf(h2hArray.get(0));
                        }

                    }

                    odds.add(new Odds(homeName, awayName, oddsHome, oddsDraw, oddsAway, siteName));

                    Log.d("ODDS", homeName + " vs. " + awayName + " on " + siteName + ". " + homeName + " " + oddsHome + " to win!");
                }

            }else{
                Log.e("Json not successful", "damnit");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return odds;
    }
}
