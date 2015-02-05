package com.example.android.sunshine.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Emilie on 2015-01-28.
 */
public class WeatherContract2 {


    public static final String CONTENT_AUTHORITY="";
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://" + CONTENT_AUTHORITY)   ;



    public static final String PATH_WEATHER="weather";
    public static final String PATH_LOCATION="location";

    public static final class locationentry implements BaseColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATION).build();

        public static final String CONTENT_TYPE=
                "vnd.android.cursor.dir/"+ CONTENT_AUTHORITY+"/"+PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE=
                "vnd.android.cursor.item/"+ CONTENT_AUTHORITY+"/"+PATH_LOCATION;


    }


    public static final class weatherentry implements BaseColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_WEATHER).build();



    }

}
