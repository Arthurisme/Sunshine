package com.example.android.sunshine.data;

import android.content.ContentUris;
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

        public static final String TABLE_NAME = "weather";

        // Column with the foreign key into the location table.
        public static final String COLUMN_LOC_KEY = "location_id";
        // Date, stored as Text with format yyyy-MM-dd
        public static final String COLUMN_DATETEXT = "date";
        // Weather id as returned by API, to identify the icon to be used
        public static final String COLUMN_WEATHER_ID = "weather_id";

        // Short description and long description of the weather, as provided by API.
        // e.g "clear" vs "sky is clear".
        public static final String COLUMN_SHORT_DESC = "short_desc";

        // Min and max temperatures for the day (stored as floats)
        public static final String COLUMN_MIN_TEMP = "min";
        public static final String COLUMN_MAX_TEMP = "max";

        // Humidity is stored as a float representing percentage
        public static final String COLUMN_HUMIDITY = "humidity";

        // Humidity is stored as a float representing percentage
        public static final String COLUMN_PRESSURE = "pressure";

        // Windspeed is stored as a float representing windspeed  mph
        public static final String COLUMN_WIND_SPEED = "wind";

        // Degrees are meteorological degrees (e.g, 0 is north, 180 is south).  Stored as floats.
        public static final String COLUMN_DEGREES = "degrees";

        //content provider

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_WEATHER).build();


        public static final String CONTENT_TYPE=
                "vnd.android.cursor.dir/"+ CONTENT_AUTHORITY+"/"+PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE=
                "vnd.android.cursor.item/"+ CONTENT_AUTHORITY+"/"+PATH_LOCATION;

        public static Uri buildWeatherUri(long id){

         return ContentUris.withAppendedId(CONTENT_URI,id);
                 }

        public static Uri buildWeatherLocation(String locationsetting){

            return CONTENT_URI.buildUpon().appendPath(locationsetting).build();
        }

        public static Uri buildWeatherLocationStartDate(String locationsetting,String StartDate){

            return CONTENT_URI.buildUpon().appendPath(locationsetting).appendQueryParameter(COLUMN_DATETEXT,StartDate).build();

        }
        public static Uri buildWeatherLocationDate(String locationsetting,String Date){

            return CONTENT_URI.buildUpon().appendPath(locationsetting).appendPath( Date).build();

        }
        public static String getLocationFromUri(Uri uri){

            return uri.getPathSegments() .get(1) ;
        }

        public static String getDateFromUri(Uri uri){

            return uri.getPathSegments() .get(2) ;
        }


        public static String getStartDateFromUri(Uri uri){

            return uri.getQueryParameter(COLUMN_DATETEXT)   ;
        }

    }

}
