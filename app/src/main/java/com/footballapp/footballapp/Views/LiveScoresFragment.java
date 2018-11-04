package com.footballapp.footballapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.APIResources;
import com.footballapp.footballapp.Helpers.LiveScoreAdapter;
import com.footballapp.footballapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveScoresFragment extends Fragment {


    public LiveScoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_livescores, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view){
        ListView livescoresListView = view.findViewById(R.id.livescoresListView);
        LiveScoreAdapter adapter = new LiveScoreAdapter(getActivity(), R.layout.livescore_list_item, APIResources.getLiveScore());
        livescoresListView.setAdapter(adapter);
    }
}
