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
import com.footballapp.footballapp.R;

import java.util.ArrayList;
import java.util.List;

public class LiveScoreAdapter extends ArrayAdapter<LiveScore> {

    public LiveScoreAdapter(@NonNull Context context, int resource, @NonNull List<LiveScore> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        LiveScore liveScore = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fixture_list_item, parent, false);
        }

        TextView homeText = convertView.findViewById(R.id.homeText);
        TextView awayText = convertView.findViewById(R.id.awayText);
        TextView timeText = convertView.findViewById(R.id.timeText);
        TextView scoreText = convertView.findViewById(R.id.scoreText);

        homeText.setText(liveScore.getHomeName());
        awayText.setText(liveScore.getAwayName());
        if(liveScore.getStatus().equals("IN PLAY") | liveScore.getStatus().equals("ADDED TIME")){
            timeText.setText(liveScore.getTime() + "'");
        }else{
            timeText.setText(liveScore.getTime());
        }
        scoreText.setText(liveScore.getScore());

        return convertView;
    }
}
