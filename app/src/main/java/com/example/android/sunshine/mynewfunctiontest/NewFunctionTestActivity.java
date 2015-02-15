package com.example.android.sunshine.mynewfunctiontest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.sunshine.R;

/*For some new idea or new function i want to impletion,this

    class is build.*/


public class NewFunctionTestActivity extends ActionBarActivity {

    static namespaces ns=new namespaces();
    static String fDATABASE_NAME =ns.DATABASE_NAME();
    static String fTABLE_NAME=ns.TABLE_NAME();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_function_test);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new NewFunctionFragment())
                    .commit();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_function_test, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class NewFunctionFragment extends Fragment {

        //Context mContext;

        public NewFunctionFragment() {
        }

        //tretrieving string from sqlite database to ShowdataActivity.class:(not using dbHelper)



        public String retrievingStringFromData() {


            SQLiteDatabase sqliteDatabase = getActivity().openOrCreateDatabase(fDATABASE_NAME, Context.MODE_WORLD_WRITEABLE, null);

            Cursor cursor = sqliteDatabase.query(fTABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null

            );

            cursor.moveToFirst();
            //String theColumn1=cursor.getString(0);
            String dataToStringStr = "";
            String[] dataToStringArray = new String[cursor.getCount()];

            for (int i = 0; i < cursor.getCount(); i++) {

                String theColumnValue = cursor.getString(0);
                dataToStringStr = dataToStringStr + "\n" + theColumnValue;
                dataToStringArray[i] = theColumnValue;
                cursor.moveToNext();


            }

            // if(cursor.()){            }
            sqliteDatabase.close();
            cursor.close();


            return dataToStringStr;
        }


        public void alter_dialog_getdata() {

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            alert.setTitle("Title");
            alert.setMessage("Message");

// Set an EditText view to get user input
            final EditText input = new EditText(getActivity());
            alert.setView(input);

            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String value = input.getText().toString();
                    // Do something with value!
                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                }
            });

            alert.show();


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_new_function_test, container, false);

            //click to store strings to database
            //1,using altert move alert from top:

            Button button_alter_getData = (Button) rootView.findViewById(R.id.button_alter_getData);

            button_alter_getData.setOnClickListener(new View.OnClickListener() {


                                                        public void onClick(View view) {

                                                            alter_dialog_getdata();

                                                        }


                                                    }
            );

            //show database on click the button:
            Button b_button_show_database = (Button) rootView.findViewById(R.id.button_show_database);

            b_button_show_database.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //sava data to another intent:

                    String readStringFromDataString = retrievingStringFromData();
                    Intent intentDataShowing = new Intent(getActivity(), ShowingDataActivity.class).putExtra(Intent.EXTRA_TEXT, readStringFromDataString);
                    ;
                    // Intent intentDataShowing=new Intent(getActivity(),ShowingDataActivity.class).putExtra(Intent., readStringFromDataString);

                    startActivity(intentDataShowing);

                }
            });

            //using onCreateDialog

            Button b_button_dialog_getdata = (Button) rootView.findViewById(R.id.button_dialog_getdata);

            b_button_dialog_getdata.setOnClickListener(new View.OnClickListener() {

                                                           public void onClick(View view) {

                                                               //new MyDialogFragment().show(getFragmentManager(),"input");

                                                               showEditDialog();
                                                           }


                                                       }

            );

            //2,using toast

            return rootView;

        }

        private void showEditDialog() {
            FragmentManager fm = getFragmentManager();
            SavingStringToDataDialog editNameDialog = new SavingStringToDataDialog();
            editNameDialog.show(fm, "fragment_getstring");
        }


        public void onFinishEditDialog(String inputText) {
            Toast.makeText(getActivity(), "Hi, " + inputText, Toast.LENGTH_SHORT).show();
        }
    }
}
