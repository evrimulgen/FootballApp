package com.footballapp.footballapp.Views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;

import com.footballapp.footballapp.Helpers.LiveScoreAPI;
import com.footballapp.footballapp.Helpers.OddsAPI;
import com.footballapp.footballapp.Helpers.PageAdapter;
import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.Fixture;
import com.footballapp.footballapp.Models.League;
import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.Models.Odds;
import com.footballapp.footballapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Country> countries;
    private ArrayList<LiveScore> LiveScore;
    private ArrayList<League> leagues;
    private ArrayList<Odds> odds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = LiveScoreAPI.getCountries();
        LiveScore = LiveScoreAPI.getLivescores();
        leagues = LiveScoreAPI.getLeagues();
        odds = OddsAPI.getOdds();


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        PageAdapter adapter = new PageAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public Country getCountry(int countryId){
        for(Country country : countries){
            if(country.getId() == countryId)
                return country;
        }
        return null;
    }

    public ArrayList<LiveScore> getLiveScore() {
        return LiveScore;
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public ArrayList<Odds> getOdds(){
        return odds;
    }

    public ArrayList<Fixture> getFixtures(int leagueId){
//        To open new fixture fragment
//
//        FixturesFragment ff = new FixturesFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("leagueId", 114);
//        ff.setArguments(bundle);

        return LiveScoreAPI.getFixtures(leagueId);
    }
}
