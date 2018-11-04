package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.League;
import com.footballapp.footballapp.R;
import com.footballapp.footballapp.Views.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeagueAdapter extends ArrayAdapter<League> {

    public LeagueAdapter(@NonNull Context context, int resource, @NonNull List<League> objects) {
        super(context, resource, objects);
    }

    static int count = 0;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        League league = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.league_list_item, parent, false);
        }

        TextView nameText = convertView.findViewById(R.id.nameText);
        TextView countryText = convertView.findViewById(R.id.countryText);

        nameText.setText(league.getName());
        countryText.setText(((MainActivity) getContext()).getCountry(league.getCountryId()).getName());

        return convertView;
    }

    private boolean hasImage(@NonNull ImageView view) {
        Drawable drawable = view.getDrawable();
        boolean hasImage = (drawable != null);

        if (hasImage && (drawable instanceof BitmapDrawable)) {
            hasImage = ((BitmapDrawable) drawable).getBitmap() != null;
        }

        return hasImage;
    }

}
