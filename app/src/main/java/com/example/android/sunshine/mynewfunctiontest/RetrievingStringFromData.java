package com.example.android.sunshine.mynewfunctiontest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.sunshine.data.WeatherContract;

/**
 * Created by Emilie on 2015-02-06.
 * this class is not using by new function test yet! just prepare for future
 */
public class RetrievingStringFromData extends SQLiteOpenHelper  {



    private static final int DATABASE_VERSION = 1;



    static namespaces ns=new namespaces();
    static String fDATABASE_NAME =ns.DATABASE_NAME();
    static String fTABLE_NAME=ns.TABLE_NAME();



    public RetrievingStringFromData(Context context) {
        super(context, fDATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_STRING_TABLE = "CREATE TABLE IF NOT EXISTS " + fTABLE_NAME + " (" +

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
