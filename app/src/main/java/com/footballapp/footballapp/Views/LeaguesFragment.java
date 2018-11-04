package com.footballapp.footballapp.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.APIResources;
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

        Bundle args = getArguments();
        int countryId = -1;
        if(args != null){
            countryId = args.getInt("countryId", -1);
        }
        initializeComponents(view, countryId);

        return view;
    }

    private void initializeComponents(View view, int countryId){
        ListView leaguesListView = view.findViewById(R.id.leaguesListView);
        final LeagueAdapter adapter = new LeagueAdapter(getActivity(), R.layout.league_list_item, APIResources.getLeagues(countryId));
        leaguesListView.setAdapter(adapter);
        leaguesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FixturesActivity.class);
                intent.putExtra("leagueId", adapter.getItem(position).getId());
                startActivity(intent);
            }
        });
    }

}
