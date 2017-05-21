package com.example.admin.movietheatrept1v3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MovieChild extends AppCompatActivity {

    private static final String SHARE = " #MovieApp";

    private String mMovie;
    private TextView mMovieTitleDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mMovieTitleDisplay = (TextView) findViewById(R.id.tv_detail_title);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mMovie = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mMovieTitleDisplay.setText(mMovie);
            }
        }
    }

}
