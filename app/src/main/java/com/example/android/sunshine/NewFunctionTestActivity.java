package com.example.android.sunshine;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class NewFunctionTestActivity extends ActionBarActivity {

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
    public static class NewFunctionFragment extends Fragment  {

        //Context mContext;

        public NewFunctionFragment() {
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
            GetStringToDataDialog editNameDialog = new GetStringToDataDialog();
            editNameDialog.show(fm, "fragment_edit_name");
        }


        public void onFinishEditDialog(String inputText) {
            Toast.makeText(getActivity(), "Hi, " + inputText, Toast.LENGTH_SHORT).show();
        }
    }
}
