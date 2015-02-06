package com.example.android.sunshine;

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



//import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
// ...

public class GetStringToDataDialog extends DialogFragment {

    private EditText mEditText;
    private Button mButton_GetStringFinished;

    public static final String DATABASE_NAME = "stringtodata4.db";
    public static final String TABLE_NAME="Stringtest";

    public GetStringToDataDialog() {
        // Empty constructor required for DialogFragment
    }

    public void StringToDatabase(){




          String SQL_CREAT_TABLE ="CREATE TABLE IF NOT EXISTS "  + TABLE_NAME + " (" +

                "STRING" + " varchar(10) "  +
                " );";


         Log.v("1239", "sql string 1239: " + SQL_CREAT_TABLE);

        String stringinsertStr="sdfsdfa3";

        String insertstringtodatabase="insert into "+ TABLE_NAME+"   values( ' "+ stringinsertStr +" ');";
        Log.v("1239", "sql string 1239: " + insertstringtodatabase);




         SQLiteDatabase sqLiteDatabase;
       sqLiteDatabase = getActivity().openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);



         sqLiteDatabase.execSQL(SQL_CREAT_TABLE);

        sqLiteDatabase.execSQL(insertstringtodatabase) ;






      //  sqLiteDatabase.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name, container);
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        mButton_GetStringFinished =(Button)view.findViewById(R.id.button_GetStringFinished);
        getDialog().setTitle("Please input a string:");

        mButton_GetStringFinished.setOnClickListener(new View.OnClickListener()
        {  public void onClick(View view){


                                                             //sqlite calling:
                                                              StringToDatabase();

                                                      //       Context context = getActivity().getApplicationContext();
                                                       //      CharSequence text = "Hello Your name has been stored!";
                                                      //       int duration = Toast.LENGTH_SHORT;

                                                       //      Toast toast = Toast.makeText(context, text, duration);
                                                       //      toast.show();



//close dialog
                                                             //getDialog().dismiss();  //this isbad way to close
                                                             GetStringToDataDialog.this.dismiss();



                                                         }

  }
     );



        return view;
    }
}