package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.footballapp.footballapp.Views.CountriesFragment;
import com.footballapp.footballapp.Views.FixturesFragment;

public class PageAdapter extends FragmentPagerAdapter{

    private Context context;

    public PageAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new CountriesFragment();
        } else if (position == 1){
            return new CountriesFragment();
        } else if(position == 2){
            return new FixturesFragment();
        } else if(position == 3){
            return new CountriesFragment();
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
                return "page 1";
            case 1:
                return "page 2";
            case 2:
                return "page 3";
            case 3:
                return "page 4";
            default:
                return "error";
        }
    }
}
