package com.example.android.sunshine.mynewfunctiontest;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.sunshine.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowingDataActivity extends ActionBarActivity {


    static namespaces ns=new namespaces();
    static String fDATABASE_NAME =ns.DATABASE_NAME();
    static String fTABLE_NAME=ns.TABLE_NAME();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_showing);

        Intent intent=this.getIntent();
        String try1240=intent.getStringExtra(intent.EXTRA_TEXT);

        //using dbhelper;
        //Context mContext;
        Context mContext = getApplicationContext();

        SQLiteDatabase sqliteDatabase=new ReadDbHelper(mContext).getReadableDatabase();

        Cursor cursor=sqliteDatabase.query(fTABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null

        );

        cursor.moveToFirst();
        //String theColumn1=cursor.getString(0);
        String dataToStringStr="";
        String[] dataToStringArray=new String[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++)
        {

            String theColumnValue=cursor.getString(0);
            dataToStringStr=dataToStringStr+"\n"+theColumnValue;
            dataToStringArray[i]=theColumnValue;
            cursor.moveToNext();





        }

        List<String> StringList = new ArrayList<String>(Arrays.asList(dataToStringArray));





        //TextView textView =
                ((TextView) findViewById(R.id.TextView_showData)).setText(dataToStringStr) ;
        ListView lw_listView_showData=(ListView)findViewById(R.id.listView_showData);

        ArrayAdapter aa=new ArrayAdapter(this,R.layout.list_view_row_item,R.id.textViewItem,StringList);

        lw_listView_showData.setAdapter(aa);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_showing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
