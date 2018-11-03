package com.footballapp.footballapp.Views;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;

import com.footballapp.footballapp.Helpers.LiveScoreAPI;
import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.Fixture;
import com.footballapp.footballapp.Models.League;
import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    LiveScoreAPI liveScoreAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liveScoreAPI = new LiveScoreAPI();
//        ArrayList<Country> countries = liveScoreAPI.getCountries();
//        Log.d("COUNTRIES", countries.size() + "");
//        ArrayList<League> leagues = liveScoreAPI.getLeagues();
//        Log.d("LEAGUES", leagues.size() + "");
//        ArrayList<Fixture> fixtures = liveScoreAPI.getFixtures();
//        Log.d("FIXTURES", fixtures.size() + "");
//        ArrayList<LiveScore> liveScores = liveScoreAPI.getLivescores();
//        Log.d("LIVESCORES", liveScores.size() + "");

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragmentContainer, new FixturesFragment()).commit();

    }

}
