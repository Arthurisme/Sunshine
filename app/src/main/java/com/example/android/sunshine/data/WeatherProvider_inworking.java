package com.example.android.sunshine.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Emilie on 2015-02-07.
 */
public class WeatherProvider_inworking extends ContentProvider {

    private static final int WEATHER=100;
    private static final int WEATHER_WITH_LOCATION=101;
    private static final int WEATHER_WITH_LOCATION_AND_DATE=102;
    private static final int LOCATION=300;
    private static final int LOCATION_ID=301;

    private static final UriMatcher sUriMatcher=buildUriMatcher();

    private   WeatherDbHelper mOpenhelper ;


    private static UriMatcher buildUriMatcher(){

        final UriMatcher marcher=new UriMatcher(UriMatcher.NO_MATCH);
        final String Authority=WeatherContract.CONTENT_AUTHORITY;

        marcher.addURI(Authority,WeatherContract.PATH_WEATHER,WEATHER);
        marcher.addURI(Authority,WeatherContract.PATH_WEATHER+"/*",WEATHER_WITH_LOCATION);
        marcher.addURI(Authority,WeatherContract.PATH_WEATHER+"/*/*",WEATHER_WITH_LOCATION_AND_DATE);


        marcher.addURI(Authority,WeatherContract.PATH_LOCATION,LOCATION);
        marcher.addURI(Authority,WeatherContract.PATH_LOCATION+"/#",LOCATION_ID);



return marcher;
    }



    @Override
    public boolean onCreate() {

        mOpenhelper=new WeatherDbHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {

        // Use the Uri Matcher to determine what kind of URI this is.
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case WEATHER_WITH_LOCATION_AND_DATE:
                return WeatherContract.WeatherEntry.CONTENT_ITEM_TYPE;
            case WEATHER_WITH_LOCATION:
                return WeatherContract.WeatherEntry.CONTENT_TYPE;
            case WEATHER:
                return WeatherContract.WeatherEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
