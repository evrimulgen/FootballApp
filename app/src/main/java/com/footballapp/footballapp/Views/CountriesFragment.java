package com.footballapp.footballapp.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.footballapp.footballapp.Helpers.APIResources;
import com.footballapp.footballapp.Helpers.CountryAdapter;
import com.footballapp.footballapp.Helpers.LiveScoreAPI;
import com.footballapp.footballapp.Helpers.LiveScoreAdapter;
import com.footballapp.footballapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountriesFragment extends Fragment {


    public CountriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_countries, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view){
        ListView countriesListView = view.findViewById(R.id.countriesListView);
        final CountryAdapter adapter = new CountryAdapter(getActivity(), R.layout.country_list_item, APIResources.getCountries());
        countriesListView.setAdapter(adapter);
        countriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), LeaguesActivity.class);
                intent.putExtra("countryId", adapter.getItem(position).getId());
                startActivity(intent);
            }
        });
    }

}
