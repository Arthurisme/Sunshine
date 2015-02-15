package com.example.android.sunshine.mynewfunctiontest;

/**
 * Created by Emilie on 2015-02-04.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.R;

//import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
// ...

public class SavingStringToDataDialog extends DialogFragment {

    private static final String LOG_TAG = SavingStringToDataDialog.class.getSimpleName();

    private EditText mEditText;
    private Button mButton_GetStringFinished;


    static namespaces ns=new namespaces();
    static String fDATABASE_NAME =ns.DATABASE_NAME();
    static String fTABLE_NAME=ns.TABLE_NAME();


    public SavingStringToDataDialog() {
        // Empty constructor required for DialogFragment
    }

    //when you input a string in the dialog, the string is saving to database by following method:
    public void SavingStringToDatabase(String string1) {

        String stringinsertStr = string1;
        Log.v("1239", "sql string 1239: " + stringinsertStr);
        // Context context=getActivity();
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        //ViewGroup container;
        //View view = inflater.inflate(R.layout.fragment_getstring, null);
        //String stringinsertStr =((EditText) view.findViewById(R.id.txt_your_string)).getText().toString();

        try {
            String SQL_CREAT_TABLE = "CREATE TABLE IF NOT EXISTS " + fTABLE_NAME +
                    " (" +

                    "STRING" + " varchar(10) " +
                    " );";

            Log.v("1239", "sql string 1239: " + SQL_CREAT_TABLE);

            String insertstringtodatabase = "insert into " + fTABLE_NAME + "   values( ' " + stringinsertStr + " ');";
            Log.v("1239", "sql string 1239: " + insertstringtodatabase);

            SQLiteDatabase sqLiteDatabase
             = getActivity().openOrCreateDatabase(fDATABASE_NAME, Context.MODE_WORLD_WRITEABLE, null);

            sqLiteDatabase.execSQL(SQL_CREAT_TABLE);

            sqLiteDatabase.execSQL(insertstringtodatabase);

            sqLiteDatabase.close();
        } catch (android.database.sqlite.SQLiteConstraintException e) {
            Log.e(LOG_TAG, "SQLiteConstraintException:" + e.getMessage());
        } catch (android.database.sqlite.SQLiteException e) {
            Log.e(LOG_TAG, "SQLiteException:" + e.getMessage());
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception:" + e.getMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_getstring, container);
        mEditText = (EditText) view.findViewById(R.id.txt_your_string);
        mButton_GetStringFinished = (Button) view.findViewById(R.id.button_GetStringFinished);
        getDialog().setTitle("Please input a string:");

        mButton_GetStringFinished.setOnClickListener(new View.OnClickListener() {
                                                         public void onClick(View view) {

//string you input:
                                                             //View view = inflater.inflate(R.layout.fragment_getstring, null);
                                                             String stringinsertStr1 = mEditText.getText().toString();
                                                             Log.v("1239", "sql string 1239: " + stringinsertStr1);

                                                             //sqlite calling:
                                                             SavingStringToDatabase(stringinsertStr1);

                                                             //       Context context = getActivity().getApplicationContext();
                                                             //      CharSequence text = "Hello Your name has been stored!";
                                                             //       int duration = Toast.LENGTH_SHORT;

                                                             //      Toast toast = Toast.makeText(context, text, duration);
                                                             //      toast.show();

//close dialog
                                                             //getDialog().dismiss();  //this isbad way to close
                                                             SavingStringToDataDialog.this.dismiss();


                                                         }

                                                     }
        );

        return view;
    }
}