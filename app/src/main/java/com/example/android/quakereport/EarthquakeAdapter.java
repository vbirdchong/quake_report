package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cccho on 2017/9/12.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarehquake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.id_mag);
        magTextView.setText(Double.toString(currentEarehquake.getMagnitude()));

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.id_place);
        placeTextView.setText(currentEarehquake.getPlace());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.id_date);
        dateTextView.setText(getDateString(currentEarehquake.getTime()));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.id_time);
        timeTextView.setText(getTimeString(currentEarehquake.getTime()));

        return listItemView;
    }

    private String getDateString(long time) {
        Date dateObject = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormat.format(dateObject);
    }

    private String getTimeString(long time) {
        Date dateObject = new Date(time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        return timeFormat.format(dateObject);
    }
}
