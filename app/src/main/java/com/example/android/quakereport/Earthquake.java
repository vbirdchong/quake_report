package com.example.android.quakereport;

/**
 * Created by cccho on 2017/9/12.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mTime;

    Earthquake(double mag, String place, long time) {
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

    public long getTime() {
        return mTime;
    }
}
