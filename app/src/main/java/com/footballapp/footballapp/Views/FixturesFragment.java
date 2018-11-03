package com.footballapp.footballapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.LiveScoreAPI;
import com.footballapp.footballapp.Helpers.LiveScoreAdapter;
import com.footballapp.footballapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FixturesFragment extends Fragment {


    public FixturesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view){
        ListView fixturesListView = view.findViewById(R.id.fixturesListView);
        LiveScoreAdapter adapter = new LiveScoreAdapter(getActivity(), R.layout.fixture_list_item, LiveScoreAPI.getLivescores());
        fixturesListView.setAdapter(adapter);
    }
}
