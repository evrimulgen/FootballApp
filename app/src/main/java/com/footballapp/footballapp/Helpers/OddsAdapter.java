package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.Models.Odds;
import com.footballapp.footballapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class OddsAdapter extends ArrayAdapter<Odds> {

    public OddsAdapter(@NonNull Context context, int resource, @NonNull List<Odds> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Odds odds = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.odds_list_item, parent, false);
        }

        TextView homeText = convertView.findViewById(R.id.homeText);
        TextView awayText = convertView.findViewById(R.id.awayText);
        TextView oddsHomeText = convertView.findViewById(R.id.oddsHomeText);
        TextView oddsDrawText = convertView.findViewById(R.id.oddsDrawText);
        TextView oddsAwayText = convertView.findViewById(R.id.oddsAwayText);

        homeText.setText(odds.getHomeName());
        awayText.setText(odds.getAwayName());
        oddsHomeText.setText(odds.getOddsHome());
        oddsDrawText.setText(odds.getOddsDraw());
        oddsAwayText.setText(odds.getOddsAway());

        return convertView;
    }
}
