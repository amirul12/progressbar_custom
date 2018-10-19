package com.edupointbd.edupoin;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog pd;
    private ProgressBar progressBar;
    private Handler mHandler;
    private int progressInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        mHandler = new Handler();
        runnable.run();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                updateProgress();
            } catch (Exception ignored) {

            } finally {
                mHandler.postDelayed(runnable, progressInt);
            }
        }
    };

    private void updateProgress() {
        progressInt += 1;
        if (progressInt > 100) {
            mHandler.removeCallbacks(runnable);
        } else {
            progressBar.setSecondaryProgress(progressInt+10);
            progressBar.setProgress(progressInt);
        }
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
