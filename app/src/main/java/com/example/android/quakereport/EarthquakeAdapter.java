package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cccho on 2017/9/12.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

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
        magTextView.setText(getFormatMagnitude(currentEarehquake.getMagnitude()));

        GradientDrawable magnitudeCircle = (GradientDrawable)  magTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarehquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String originalPlace = currentEarehquake.getPlace();
        String locationOffset;
        String primaryLocation;
        if (originalPlace.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalPlace.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalPlace;
        }

        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.id_location_offset);
        locationOffsetTextView.setText(locationOffset);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.id_place);
        placeTextView.setText(primaryLocation);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.id_date);
        dateTextView.setText(getDateString(currentEarehquake.getTime()));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.id_time);
        timeTextView.setText(getTimeString(currentEarehquake.getTime()));

        return listItemView;
    }

    private String getDateString(long time) {
        Date dateObject = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String getTimeString(long time) {
        Date dateObject = new Date(time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        return timeFormat.format(dateObject);
    }

    private String getFormatMagnitude(double mag) {
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return  magFormat.format(mag);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String getLocationOffset(String placeInfo) {
        // 虽然可以实现通用的功能，但还是避免使用hard code
        String locationOffset = "Near by";
        int indexOf = placeInfo.indexOf("of");
        if (indexOf != -1) {
            locationOffset = placeInfo.substring(0, indexOf + 2);
        }

        return locationOffset;
    }

    private String getPrimaryLocation(String placeInfo) {
        String primaryLocation = "";
        int indexOf = placeInfo.indexOf("of");
        if (indexOf != -1) {
            primaryLocation = placeInfo.substring(indexOf + 3, placeInfo.length());
        }else {
            primaryLocation = placeInfo;
        }

        return primaryLocation;
    }
}
