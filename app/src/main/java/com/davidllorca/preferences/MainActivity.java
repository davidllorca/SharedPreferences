package com.davidllorca.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Save data in SharedPreferences.
     *
     * @param blockValue String name of block's preferences.
     * @param keyValue String.
     * @param valueValue String.
     */
    protected void save(String blockValue, String keyValue, String valueValue){

        // Check if key's field isn't empty
        if("".equals(keyValue)){
            showMessage(R.string.no_key);
            return;
        }

        // Check if values's field isn't empty
        if("".equals(valueValue)){
            showMessage(R.string.no_value);
            return;
        }

        /*
         Save SharedPreferences
         Mode:
         - Context.MODE_PRIVATE(0): acces only allowed from app.
         - Context.MODE_WORLD_READABLE(1): read permission from others apps.
         - Context.MODE_WORLD_WRITABLE(2): read/write permission froms others apps.
          */
        // Obtain object SharedPreferences
        SharedPreferences preferences =  null;
        if(!"".equals(blockValue)){
            preferences = getSharedPreferences(blockValue,0);
        } else {
            preferences = getPreferences(0);
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(keyValue,valueValue);
        // save key-value
        editor.commit();

    }

    /**
     * Retrieve a value from SharedPreferences by key.
     *
     * @param blockValue
     * @param keyValue
     * @return String value.
     */
    protected String retrieve(String blockValue, String keyValue){

        // Check if key's field isn't empty
        if("".equals(keyValue)){
            showMessage(R.string.no_key);
            return "";
        }

        // Obtain object SharedPreferences
        SharedPreferences preferences =  null;
        if(!"".equals(blockValue)){
            preferences = getSharedPreferences(blockValue,0);
        } else {
            preferences = getPreferences(0);
        }

        String valueValue = preferences.getString(keyValue, getResources().getString(R.string.default_value));
        return valueValue;
    }

    /**
     * Show toast message.
     *
     * @param message string resource.
     */
    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
