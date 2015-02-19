package com.games.bean.arithmaticker;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;


public class Arithmaticker extends ActionBarActivity {

    private Chronometer chronometer;
    private long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arithmaticker_activity);
        chronometer = (Chronometer) findViewById(R.id.arith_timer);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.arithmaticker_menu, menu);
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

    public void startArithTimer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
    }

    public void resetArithTimer(View v){
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
    }

    public void pauseArithTimer(View v){
        chronometer.stop();
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
    }








}
