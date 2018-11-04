package com.footballapp.footballapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.CountryAdapter;
import com.footballapp.footballapp.Helpers.LeagueAdapter;
import com.footballapp.footballapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaguesFragment extends Fragment {


    public LeaguesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view){
        ListView leaguesListView = view.findViewById(R.id.leaguesListView);
        LeagueAdapter adapter = new LeagueAdapter(getActivity(), R.layout.league_list_item, ((MainActivity) getActivity()).getLeagues());
        leaguesListView.setAdapter(adapter);
    }

}
