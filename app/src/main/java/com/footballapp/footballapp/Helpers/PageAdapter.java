package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.footballapp.footballapp.Views.CountriesFragment;
import com.footballapp.footballapp.Views.FixturesFragment;
import com.footballapp.footballapp.Views.LeaguesFragment;
import com.footballapp.footballapp.Views.LiveScoresFragment;
import com.footballapp.footballapp.Views.OddsFragment;

public class PageAdapter extends FragmentPagerAdapter{

    private Context context;

    public PageAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new LiveScoresFragment();
        } else if (position == 1){
            return new CountriesFragment();
        } else if(position == 2){
            return new LeaguesFragment();
        } else if(position == 3){
            return new OddsFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "live";
            case 1:
                return "countries";
            case 2:
                return "leagues";
            case 3:
                return "odds";
            default:
                return "error";
        }
    }
}
