package com.example.android.quakereport;

/**
 * Created by cccho on 2017/9/12.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mTime;
    private String mUrl;

    Earthquake(double mag, String place, long time, String url) {
        mMagnitude = mag;
        mPlace = place;
        mTime = time;
        mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }
}
