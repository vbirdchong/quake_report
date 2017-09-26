package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by cccho on 2017/9/25.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        Log.i(LOG_TAG, "Test:EarthquakeLoader construct");
        mUrl = url;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        Log.i(LOG_TAG, "Test:loadInBackground");
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
