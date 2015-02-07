package com.example.android.sunshine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.sunshine.data.WeatherContract;

/**
 * Created by Emilie on 2015-02-06.
 */
public class RetrievingStringFromData extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "stringtodata4.db";
    public static final String TABLE_NAME = "Stringtest";

    public RetrievingStringFromData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_STRING_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +

                "STRING" + " varchar(10) " +
                " );";





        sqLiteDatabase.execSQL(SQL_CREATE_STRING_TABLE);


    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WeatherContract.LocationEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WeatherContract.WeatherEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }







}
