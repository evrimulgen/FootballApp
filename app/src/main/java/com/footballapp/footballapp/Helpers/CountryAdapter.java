package com.footballapp.footballapp.Helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.footballapp.footballapp.Models.Country;
import com.footballapp.footballapp.Models.LiveScore;
import com.footballapp.footballapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
    }

    static int count = 0;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Country country = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_list_item, parent, false);
        }

        TextView nameText = convertView.findViewById(R.id.nameText);
        ImageView flagImage = convertView.findViewById(R.id.flagImage);

        nameText.setText(country.getName());

        Picasso.get().load("https://www.countryflags.io/" + country.getCountryCode() + "/flat/64.png").into(flagImage);

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
