package com.example.android.quakereport;

/**
 * Created by cccho on 2017/9/12.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private String mTime;

    Earthquake(double mag, String place, String time) {
        mMagnitude = mag;
        mPlace = place;
        mTime = time;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTime() {
        return mTime;
    }
}
