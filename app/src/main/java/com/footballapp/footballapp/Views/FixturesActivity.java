package com.footballapp.footballapp.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.footballapp.footballapp.R;

public class FixturesActivity extends AppCompatActivity{

    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixtures_activity);

        fragmentContainer = findViewById(R.id.fragmentContainerFixture);
        FixturesFragment frag = new FixturesFragment();
        Bundle args = new Bundle();
        args.putInt("leagueId", getIntent().getExtras().getInt("leagueId", -1));
        frag.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainerFixture, frag);
        transaction.commit();
    }
}
