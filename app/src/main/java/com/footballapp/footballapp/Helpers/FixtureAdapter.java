package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.footballapp.footballapp.Models.Fixture;
import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class FixtureAdapter extends ArrayAdapter<Fixture> {

    public FixtureAdapter(@NonNull Context context, int resource, @NonNull List<Fixture> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Fixture fixture = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fixture_list_item, parent, false);
        }

        TextView homeText = convertView.findViewById(R.id.homeText);
        TextView awayText = convertView.findViewById(R.id.awayText);
        TextView locationText = convertView.findViewById(R.id.locationText);
        TextView dateText = convertView.findViewById(R.id.dateText);

        homeText.setText(fixture.getHomeName());
        awayText.setText(fixture.getAwayName());
        locationText.setText(fixture.getLocation());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateText.setText(dateFormat.format(fixture.getDate()));

        return convertView;
    }
}
