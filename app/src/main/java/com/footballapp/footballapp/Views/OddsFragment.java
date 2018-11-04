package com.footballapp.footballapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.APIResources;
import com.footballapp.footballapp.Helpers.LiveScoreAdapter;
import com.footballapp.footballapp.Helpers.OddsAdapter;
import com.footballapp.footballapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OddsFragment extends Fragment {


    public OddsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_odds, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view){
        ListView oddsListView = view.findViewById(R.id.oddsListView);
        OddsAdapter adapter = new OddsAdapter(getActivity(), R.layout.odds_list_item, APIResources.getOdds());
        oddsListView.setAdapter(adapter);
    }
}
